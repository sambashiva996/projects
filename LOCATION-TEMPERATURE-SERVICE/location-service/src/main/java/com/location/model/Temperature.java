package com.location.model;

import lombok.Data;

@Data
public class Temperature {
	private Long temperatureSeqId;
	private String temperatureValue;
	private String temperatureLevel;
	private String city;
}