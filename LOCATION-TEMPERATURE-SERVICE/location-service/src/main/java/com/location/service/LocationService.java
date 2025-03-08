package com.location.service;

import com.location.entity.Location;
import com.location.model.LocationReq;
import com.location.model.LocationRes;

public interface LocationService {
    LocationReq saveLocation(LocationReq locationReq);

    LocationRes getLocation(String locationName);
}