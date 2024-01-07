package com.smartdiscover.parkinglotapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ParkingOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private ParkingSpace parkingSpace;

    private LocalDateTime entry;
    private LocalDateTime exit;

    private String parkingOrderNum;

    @OneToOne
    private Payment payment;

    public ParkingOrder(Vehicle vehicle, ParkingSpace parkingSpace) {
        this.vehicle = vehicle;
        this.parkingSpace = parkingSpace;
        this.entry = LocalDateTime.now();
        this.parkingOrderNum = String.valueOf(System.currentTimeMillis()); // TODO implement ParkingOrderNumGenerator
    }

}
