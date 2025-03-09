package com.location.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "LOCATION")
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOCATION_SEQ")
    @SequenceGenerator(name = "LOCATION_SEQ", sequenceName = "LOCATION_SEQ_ID")
    private Long locationSeqId;
    private String name;
//    @OneToMany(mappedBy = "locationSeqId")
//    private List<Address> address;
}
