package com.temperature.controller;

import com.temperature.model.TemperatureReq;
import com.temperature.service.TemperatureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/temperature-service")
public class TemperatureController {

    private static final Logger logger = LoggerFactory.getLogger(TemperatureController.class);

    @Autowired
    private TemperatureService temperatureService;

    @PostMapping(value = "/save-temperature", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TemperatureReq> saveTemperature(@RequestBody TemperatureReq temperatureReq){
        logger.info("saveTemperature() started");
        TemperatureReq temperatureResponse = temperatureService.saveTemperature(temperatureReq);

        logger.info("saveTemperature() completed");
        return ResponseEntity.status(HttpStatus.CREATED).body(temperatureResponse);
    }

    @GetMapping("/temperature/{city}")
    public ResponseEntity<TemperatureReq> getTemperature(@PathVariable("city") String city){
        logger.info("getTemperature() started");
        TemperatureReq temperature=  temperatureService.getTemperature(city);
        logger.info("getTemperature() completed");
        return ResponseEntity.status(HttpStatus.OK).body(temperature);
    }

    @GetMapping("/temperatures")
    public ResponseEntity<List<TemperatureReq>> getTemperatureList(){
        logger.info("getTemperatureList() started");
        List<TemperatureReq> temperatureReqList = temperatureService.getTemperatureList();
        logger.info("getTemperatureList() completed");
        return ResponseEntity.status(HttpStatus.OK).body(temperatureReqList);
    }
}
