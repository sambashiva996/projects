package com.location.model;

import lombok.Data;

import javax.persistence.*;

@Data
public class Temperature {
	private Long temperatureSeqId;
	private String temperatureValue;
	private String temperatureLevel;
	private String city;
}