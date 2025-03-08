package com.spring.security.spring.security.jwt.token.controller;

import com.spring.security.spring.security.jwt.token.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {

    public List<Student> studentList = new ArrayList<>(List.of(new Student(1, "samba", 28), new Student(2, "shivudu", 28)));

    @GetMapping("/students")
    public List<Student> getStudentList(){
        return studentList;
    }

    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student){
        studentList.add(student);
        return student;
    }

    @GetMapping("/csrf-token")
    public CsrfToken csrfToken(HttpServletRequest httpServletRequest){
        return (CsrfToken) httpServletRequest.getAttribute("_csrf");

    }

}
