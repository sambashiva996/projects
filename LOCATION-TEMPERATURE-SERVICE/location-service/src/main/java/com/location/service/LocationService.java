package com.location.service;

import com.location.entity.Location;
import com.location.model.LocationReq;
import com.location.model.LocationRes;

import java.util.List;

public interface LocationService {
    LocationReq saveLocation(LocationReq locationReq);

    LocationReq getLocationId(Long locationId);

    List<LocationReq> getLocationList();
}