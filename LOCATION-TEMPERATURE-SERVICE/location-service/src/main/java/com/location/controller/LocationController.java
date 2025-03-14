package com.location.controller;

import com.location.entity.Location;
import com.location.model.LocationReq;
import com.location.model.LocationRes;
import com.location.service.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location-service")
public class LocationController {

    private static final Logger logger = LoggerFactory.getLogger(LocationController.class);

    @Autowired
    private LocationService locationService;

    @PostMapping(value = "/location", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LocationReq> saveLocation(@RequestBody LocationReq locationReq){
        logger.info("saveLocation() started");
        LocationReq locationResponse = locationService.saveLocation(locationReq);
        logger.info("saveLocation() completed");

        return ResponseEntity.status(HttpStatus.CREATED).body(locationResponse);
    }

    @GetMapping(value = "/location-by-id/{locationId}")
    public ResponseEntity<LocationReq> getLocation(@PathVariable("locationId") Long locationId){
        logger.info("getLocation() started");
        LocationReq locationResponse = locationService.getLocationId(locationId);
        logger.info("getLocation() completed");
        return ResponseEntity.status(HttpStatus.OK).body(locationResponse);
    }

    @GetMapping(value = "/location-by-name/{city}")
    public ResponseEntity<LocationReq> getLocationByCity(@PathVariable("city") String city){
        logger.info("getLocationByCity() started");
        LocationReq locationResponse = locationService.getLocationByCity(city);
        logger.info("getLocationByCity() completed");
        return ResponseEntity.status(HttpStatus.OK).body(locationResponse);
    }

    @GetMapping("/locations")
    public ResponseEntity<List<LocationReq>> getLocationList(){
        logger.info("getLocationList() started");
        List<LocationReq> locationList = locationService.getLocationList();
        logger.info("getLocationList() completed");
        return ResponseEntity.ok().body(locationList);
    }

    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }
}
