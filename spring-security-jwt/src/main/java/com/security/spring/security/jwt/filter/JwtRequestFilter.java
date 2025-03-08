package com.security.spring.security.jwt.filter;

import ch.qos.logback.core.util.StringUtil;
import com.security.spring.security.jwt.utils.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtRequestFilter.class);

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String servletPath = request.getServletPath();
        String requestURI = request.getRequestURI();
        System.out.println("servletPath : "+servletPath + " requestURI : "+requestURI);

        if (request.getServletPath().equals("/api/authenticate")) {
            System.out.println("Skipping JWT filter for /api/authenticate");
            filterChain.doFilter(request, response);
            return;
        }
        else {

        try {

            final String authHeader = request.getHeader("Authorization");

            String userName = null;
            String jwtToken = null;
            if (!StringUtil.isNullOrEmpty(authHeader) && authHeader.startsWith("Bearer ")) {
                jwtToken = authHeader.substring(7);
                userName = jwtUtils.extractUsername(jwtToken);
            }

            if (!StringUtil.isNullOrEmpty(userName) && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);

                if (jwtUtils.validateJwtToken(jwtToken, userDetails.getUsername())) {
                    var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            logger.error("error occurred during doFilterInternal() : {}", e);
        }
        }
    }
}
