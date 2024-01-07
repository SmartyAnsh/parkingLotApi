package com.smartdiscover.parkinglotapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExitRequestModel {

    private String parkingOrderNum;
    private String registrationNum;
}
