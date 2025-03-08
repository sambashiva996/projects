package com.temperature.service;

import com.temperature.entity.Temperature;
import com.temperature.model.TemperatureReq;
import com.temperature.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class TemperatureImpl implements TemperatureService{

    @Autowired
    private TemperatureRepository temperatureRepository;


    @Override
    public Temperature saveTemperature(TemperatureReq temperatureReq) {
        Temperature temperature = new Temperature();
        temperature.setTemperatureValue(temperatureReq.getTemperatureValue());
        temperature.setTemperatureLevel(temperatureReq.getTemperatureLevel());
        temperature.setCity(temperatureReq.getCity().toLowerCase());
        return temperatureRepository.save(temperature);
    }

    @Override
    public Temperature getTemperature(String temperatureName) {
        return temperatureRepository.findByCity(temperatureName);
    }
}
