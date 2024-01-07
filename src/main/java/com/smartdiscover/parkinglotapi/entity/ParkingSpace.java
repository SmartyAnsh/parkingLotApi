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
public class ParkingSpace {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @ManyToOne
    private SpaceType type;

    private boolean isOccupied = false;

    @ManyToOne
    @JoinColumn(name="parking_lot_id", nullable=false)
    private ParkingLot parkingLot;

    public ParkingSpace(String name, SpaceType type, ParkingLot parkingLot) {
        this.name = name;
        this.type = type;
        this.parkingLot = parkingLot;
    }

}
