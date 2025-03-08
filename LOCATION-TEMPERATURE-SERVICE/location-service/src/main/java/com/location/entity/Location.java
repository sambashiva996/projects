package com.location.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "LOCATION")
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence-id-gen")
    @SequenceGenerator(name = "sequence-id-gen", sequenceName = "LOCATION_SEQ_ID")
    private Long locationSeqId;
    private String name;
//    @OneToMany(mappedBy = "locationSeqId")
//    private List<Address> address;
}
