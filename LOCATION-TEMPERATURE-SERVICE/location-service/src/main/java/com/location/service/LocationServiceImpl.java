package com.location.service;

import com.location.entity.Address;
import com.location.entity.Location;
import com.location.model.LocationReq;
import com.location.model.LocationRes;
import com.location.model.Temperature;
import com.location.repository.AddressRepository;
import com.location.repository.LocationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public LocationReq saveLocation(LocationReq locationReq) {

        Location location = new Location();
        BeanUtils.copyProperties(locationReq, location);

        Location locationRes = locationRepository.save(location);

        Address address = new Address();
        address.setLocationSeqId(locationRes.getLocationSeqId());
        address.setCity(locationReq.getCity());
        address.setCountry(locationReq.getCountry());
        address.setPinCode(locationReq.getPinCode());

        addressRepository.save(address);

        locationReq.setLocationSeqId(locationRes.getLocationSeqId());
        return locationReq;
    }

    @Override
    public LocationReq getLocationId(Long locationId) {
        Optional<Location> optionalLocation = locationRepository.findById(locationId);
        LocationReq locationRes = new LocationReq();
        optionalLocation.ifPresent(location -> BeanUtils.copyProperties(location, locationRes));
        return locationRes;
    }

    @Override
    public List<LocationReq> getLocationList() {
        List<Location> locationList = locationRepository.findAll();

        List<LocationReq> locationReqList = new ArrayList<>();

        for (Location location : locationList) {
            LocationReq locationReq = new LocationReq();
            BeanUtils.copyProperties(location, locationReq);
            locationReqList.add(locationReq);
        }

        return locationReqList;
    }
}
