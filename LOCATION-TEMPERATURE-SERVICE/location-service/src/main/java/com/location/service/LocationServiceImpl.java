package com.location.service;

import com.location.entity.Address;
import com.location.entity.Location;
import com.location.model.LocationReq;
import com.location.model.LocationRes;
import com.location.model.Temperature;
import com.location.repository.AddressRepository;
import com.location.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;

@Service
public class LocationServiceImpl implements LocationService{

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public LocationReq saveLocation(LocationReq locationReq) {

        Location location = new Location();
        location.setName(locationReq.getName().toLowerCase());

        Location locationRes = locationRepository.save(location);

        Address address = new Address();
        address.setLocationSeqId(locationRes.getLocationSeqId());
        address.setCity(locationReq.getCity().toLowerCase());
        address.setCountry(locationReq.getCountry().toLowerCase());
        address.setPinCode(locationReq.getPinCode());

        addressRepository.save(address);

        return locationReq;
    }

    @Override
    public LocationRes getLocation(String locationName) {

        Location location = locationRepository.findByName(locationName);

        WebClient webClient = WebClient
                .builder()
                .baseUrl("http://localhost:9002")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", "http://localhost:9002"))
                .build();

        Mono<Temperature> temperatureMono = webClient
                .get()
                .uri("/temperature/"+location.getName())
                .retrieve()
                .bodyToMono(Temperature.class);

        Temperature block = temperatureMono.block();

        LocationRes locationRes = new LocationRes();
        locationRes.setName(block.getCity());
        locationRes.setCountry(locationRes.getCountry());
        locationRes.setPinCode(locationRes.getPinCode());
        locationRes.setCity(locationRes.getName());
        locationRes.setTemperatureSeqId(block.getTemperatureSeqId());
        locationRes.setTemperatureValue(block.getTemperatureValue());
        locationRes.setTemperatureLevel(block.getTemperatureLevel());
        locationRes.setLocationSeqId(location.getLocationSeqId());

        return locationRes;
    }
}
