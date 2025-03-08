package com.temperature.service;

import com.temperature.entity.Temperature;
import com.temperature.model.TemperatureReq;

public interface TemperatureService {
    Temperature saveTemperature(TemperatureReq temperatureReq);

    Temperature getTemperature(String temperatureName);
}
