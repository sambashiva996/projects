package com.location.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ADDRESS")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRESS_SEQ")
    @SequenceGenerator(name = "ADDRESS_SEQ", sequenceName = "ADDRESS_SEQ_ID")
    private Long addressSeqId;
    private Long locationSeqId;
    private String city;
    private String country;
    private String pinCode;
}
