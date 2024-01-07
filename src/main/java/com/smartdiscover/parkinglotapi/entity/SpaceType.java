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
public class SpaceType {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String typeName;

    private boolean isElectricChargerAvailable;

    @Enumerated(EnumType.STRING)
    private Vehicle.VehicleSize size;

    public SpaceType(String typeName, boolean isElectricChargerAvailable, Vehicle.VehicleSize size) {
        this.typeName = typeName;
        this.isElectricChargerAvailable = isElectricChargerAvailable;
        this.size = size;
    }

}
