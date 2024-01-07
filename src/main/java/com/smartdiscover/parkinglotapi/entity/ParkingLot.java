package com.smartdiscover.parkinglotapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

import static jakarta.persistence.CascadeType.ALL;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ParkingLot {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String address; //TODO create an Address entity

    @OneToMany(cascade = ALL, mappedBy = "parkingLot")
    private Set<ParkingSpace> spaces;

    @OneToOne
    private RatesConfig ratesConfig;

    public ParkingLot(String name, String address) {
        this.name = name;
        this.address = address;
    }

}
