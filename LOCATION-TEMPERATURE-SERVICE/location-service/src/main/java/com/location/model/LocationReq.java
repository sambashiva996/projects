package com.location.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.location.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationReq {
    private Long locationSeqId;
    private String name;
    private String city;
    private String country;
    private String pinCode;
    @JsonIgnore
    private Long temperatureSeqId;
    @JsonIgnore
    private String temperatureValue;
    @JsonIgnore
    private String temperatureLevel;
}
