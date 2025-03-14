package com.location.service;

import com.location.entity.Address;
import com.location.entity.Location;
import com.location.model.LocationReq;
import com.location.model.TemperatureReq;
import com.location.repository.AddressRepository;
import com.location.repository.LocationRepository;
import com.location.webclient.TemperatureServiceWebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class LocationServiceImpl implements LocationService {

    Logger logger = LoggerFactory.getLogger(LocationServiceImpl.class);


    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    TemperatureServiceWebClient temperatureServiceWebClient;

    @Override
    public LocationReq saveLocation(LocationReq locationReq) {
        logger.info("saveLocation() started");
        logger.debug("saveLocation() locationReq : {}", locationReq);

        Location location = new Location();
        BeanUtils.copyProperties(locationReq, location);

        Location locationRes = locationRepository.save(location);
        logger.info("saveLocation() locationRes : {}", locationRes);
        Address address = new Address();
        address.setLocationSeqId(locationRes.getLocationSeqId());
        address.setCity(locationReq.getCity());
        address.setCountry(locationReq.getCountry());
        address.setPinCode(locationReq.getPinCode());

        addressRepository.save(address);
        logger.info("saveLocation() address saved");

        locationReq.setLocationSeqId(locationRes.getLocationSeqId());
        logger.info("saveLocation() completed");
        logger.debug("saveLocation() locationReq : {}", locationReq);
        return locationReq;
    }

    @Override
    public LocationReq getLocationId(Long locationId) {
        logger.info("getLocationId() started with locationId {} :", locationId);
        Optional<Location> optionalLocation = locationRepository.findById(locationId);
        LocationReq locationRes = new LocationReq();
        optionalLocation.ifPresent(location -> BeanUtils.copyProperties(location, locationRes));
        logger.debug("getLocationId() locationRes : {}", locationRes);
        logger.info("getLocationId() completed");
        return locationRes;
    }

    @Override
    public List<LocationReq> getLocationList() {
        logger.info("getLocationList() started");
        List<Location> locationList = locationRepository.findAll();

        List<LocationReq> locationReqList = new ArrayList<>();

        for (Location location : locationList) {
            LocationReq locationReq = new LocationReq();
            BeanUtils.copyProperties(location, locationReq);
            locationReqList.add(locationReq);
        }

        logger.debug("getLocationList() locationReqList : {}", locationReqList);
        logger.info("getLocationList() completed");
        return locationReqList;
    }

    @Override
    public LocationReq getLocationByCity(String city) {
        logger.info("getLocationByCity() started with city {} :", city);

        Location location = locationRepository.findByCity(city);

        LocationReq locationReq = new LocationReq();
        BeanUtils.copyProperties(location, locationReq);

        TemperatureReq temperatureRes = temperatureServiceWebClient.getTemperatureByCity(city);

        locationReq.setTemperatureSeqId(temperatureRes.getTemperatureSeqId());
        locationReq.setTemperatureValue(temperatureRes.getTemperatureValue());
        locationReq.setTemperatureLevel(temperatureRes.getTemperatureLevel());

        logger.debug("getLocationByCity() locationReq : {}", locationReq);
        logger.info("getLocationByCity() completed");
        return locationReq;
    }
}
