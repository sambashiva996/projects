package com.temperature.service;

import com.temperature.entity.Temperature;
import com.temperature.model.TemperatureReq;

import java.util.List;

public interface TemperatureService {
    TemperatureReq saveTemperature(TemperatureReq temperatureReq);

    TemperatureReq getTemperature(String temperatureName);

    List<TemperatureReq> getTemperatureList();
}
