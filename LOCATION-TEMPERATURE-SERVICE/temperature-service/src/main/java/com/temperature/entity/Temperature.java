package com.temperature.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TEMPERATURE")
@Data
public class Temperature {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq-id-gen")
	@SequenceGenerator(name = "seq-id-gen", sequenceName = "TEMPERATURE_SEQ_ID")
	private Long temperatureSeqId;
	private String temperatureValue;
	private String temperatureLevel;
	private String city;
}