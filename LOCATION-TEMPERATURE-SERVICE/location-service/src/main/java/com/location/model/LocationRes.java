package com.location.model;

import lombok.Data;

@Data
public class LocationRes {

    private Long locationSeqId;
    private String name;
    private String city;
    private String country;
    private String pinCode;
    private Long temperatureSeqId;
    private String temperatureValue;
    private String temperatureLevel;
}
