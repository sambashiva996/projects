package com.location.service;

import com.location.model.LocationReq;

import java.util.List;

public interface LocationService {
    LocationReq saveLocation(LocationReq locationReq);

    LocationReq getLocationId(Long locationId);

    List<LocationReq> getLocationList();

    LocationReq getLocationByCity(String city);
}