package com.location.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ADDRESS")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence-id-gen")
    @SequenceGenerator(name = "sequence-id-gen", sequenceName = "ADDRESS_SEQ_ID")
    private Long addressSeqId;
    private Long locationSeqId;
    private String city;
    private String country;
    @Size(min = 1, max = 6)
    private String pinCode;
}
