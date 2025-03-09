package com.temperature.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "TEMPERATURE")
@Data
public class Temperature {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEMPERATURE_SEQ")
	@SequenceGenerator(name = "TEMPERATURE_SEQ", sequenceName = "TEMPERATURE_SEQ_ID")
	private Long temperatureSeqId;
	private String temperatureValue;
	private String temperatureLevel;
	private String city;
}