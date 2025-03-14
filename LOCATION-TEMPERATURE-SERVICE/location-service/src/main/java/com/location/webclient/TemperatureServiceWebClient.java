package com.location.webclient;

import com.location.exception.LocationServiceException;
import com.location.model.TemperatureReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class TemperatureServiceWebClient {

    Logger logger = LoggerFactory.getLogger(TemperatureServiceWebClient.class);

    @Autowired
    private WebClient webClient;

    public TemperatureReq getTemperatureByCity(String city) {
        logger.info("getTemperatureByCity() started with city {} :", city);
        Mono<TemperatureReq> temperatureReqMono = webClient.get()
                .uri("/temperature/{city}", city)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> Mono.error(new LocationServiceException("City not found from TemperatureService")))
                .bodyToMono(TemperatureReq.class);
        logger.info("getTemperatureByCity() completed");
        return temperatureReqMono.block();

    }
}
