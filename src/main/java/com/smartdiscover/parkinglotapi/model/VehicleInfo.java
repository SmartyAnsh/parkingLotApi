package com.smartdiscover.parkinglotapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class VehicleInfo {

    private String makerName;
    private String modelName;
    private String registrationNum;
    private LocalDate registrationDate;
    private String type; //hatchback, sedan, SUV, etc
    private String engineNum;
    private String chassisNum;
    private boolean canElectricCharge;

}
