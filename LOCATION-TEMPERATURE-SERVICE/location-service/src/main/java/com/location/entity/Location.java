package com.location.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "LOCATION")
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOCATION_SEQ")
    @SequenceGenerator(name = "LOCATION_SEQ", sequenceName = "LOCATION_SEQ_ID")
    private Long locationSeqId;
    private String name;
    private String city;
    private String country;
    private String pinCode;
    @OneToMany(mappedBy = "location" , cascade = CascadeType.ALL)
    private List<Address> address;
}
