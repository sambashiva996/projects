package com.temperature.service;

import com.temperature.entity.Temperature;
import com.temperature.exception.TemperatureException;
import com.temperature.model.TemperatureReq;
import com.temperature.repository.TemperatureRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Transactional
@Service
public class TemperatureImpl implements TemperatureService{

    @Autowired
    private TemperatureRepository temperatureRepository;


    @Override
    public TemperatureReq saveTemperature(TemperatureReq temperatureReq) {
        Temperature temperature = new Temperature();

        BeanUtils.copyProperties(temperatureReq, temperature);

        Temperature save = temperatureRepository.save(temperature);

        temperatureReq.setTemperatureSeqId(save.getTemperatureSeqId());
        return temperatureReq;
    }

    @Override
    public TemperatureReq getTemperature(String temperatureName) {
        Optional<Temperature> optionalTemperature = temperatureRepository.findByCity(temperatureName);
        optionalTemperature.orElseThrow(()-> new TemperatureException("Temperature not found"));
        TemperatureReq temperatureReq = new TemperatureReq();

        optionalTemperature.ifPresent(temperature -> BeanUtils.copyProperties(temperature, temperatureReq));

        return temperatureReq;
    }

    @Override
    public List<TemperatureReq> getTemperatureList() {

        List<Temperature> temperatureList = temperatureRepository.findAll();
        List<TemperatureReq> temperatureReqList = new ArrayList<>();

        if(!temperatureList.isEmpty()){
            TemperatureReq temperatureReq = new TemperatureReq();
            for (Temperature temperature : temperatureList) {
                BeanUtils.copyProperties(temperature, temperatureReq);
                temperatureReqList.add(temperatureReq);
            }
        }

        return temperatureReqList;
    }
}
