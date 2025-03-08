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

@RestController
@RequestMapping(value = "/location")
public class LocationController {

    private static final Logger logger = LoggerFactory.getLogger(LocationController.class);

    @Autowired
    private LocationService locationService;

    @PostMapping(value = "/save-location", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LocationReq> saveLocation(@RequestBody LocationReq locationReq){

        LocationReq locationResponse = locationService.saveLocation(locationReq);

        return ResponseEntity.status(HttpStatus.CREATED).body(locationResponse);
    }

    @GetMapping("/temperature/{locationName}")
    public ResponseEntity<LocationRes> getLocation(@PathVariable String locationName){

        LocationRes locationRes = locationService.getLocation(locationName);

        return ResponseEntity.status(HttpStatus.OK).body(locationRes);
    }
}
