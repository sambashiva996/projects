package com.temperature.controller;

import com.temperature.entity.Temperature;
import com.temperature.model.TemperatureReq;
import com.temperature.service.TemperatureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/temperature")
public class TemperatureController {

    private static final Logger logger = LoggerFactory.getLogger(TemperatureController.class);
    @Autowired
    private TemperatureService temperatureService;

    @PostMapping(value = "/save-temperature", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Temperature> saveTemperature(@RequestBody TemperatureReq temperatureReq){

        Temperature temperatureResponse = temperatureService.saveTemperature(temperatureReq);

        return ResponseEntity.status(HttpStatus.CREATED).body(temperatureResponse);
    }

    @GetMapping("/temperature/{temperatureName}")
    public ResponseEntity<Temperature> getTemperature(@PathVariable("temperatureName") String temperatureName){

       Temperature temperature=  temperatureService.getTemperature(temperatureName);

        return ResponseEntity.status(HttpStatus.OK).body(temperature);
    }
}
