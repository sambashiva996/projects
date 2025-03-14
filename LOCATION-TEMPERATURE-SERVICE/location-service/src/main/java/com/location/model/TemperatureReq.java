package com.temperature.model;

import lombok.Data;

@Data
public class TemperatureReq {
    private Long temperatureSeqId;
    private String city;
    private String temperatureValue;
    private String temperatureLevel;
}
