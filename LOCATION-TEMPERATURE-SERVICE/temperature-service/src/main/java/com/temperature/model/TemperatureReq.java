package com.temperature.model;

import lombok.Data;

@Data
public class TemperatureReq {
    private String city;
    private String temperatureValue;
    private String temperatureLevel;
}
