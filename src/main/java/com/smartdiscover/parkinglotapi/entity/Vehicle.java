package com.smartdiscover.parkinglotapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String registrationNum; //TODO create a vehicle registration class

    @Enumerated(EnumType.STRING)
    private VehicleSize size;

    private boolean canElectricCharge;

    //TODO add other properties - create a vehicle details class

    public enum VehicleSize {

        LARGE, MEDIUM, SMALL;

    }
}
