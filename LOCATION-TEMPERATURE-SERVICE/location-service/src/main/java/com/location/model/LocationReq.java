package com.location.model;

import com.location.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationReq {
    private String name;
    private String city;
    private String country;
    private String pinCode;
}
