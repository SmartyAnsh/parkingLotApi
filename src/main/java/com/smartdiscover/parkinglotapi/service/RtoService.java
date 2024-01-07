package com.smartdiscover.parkinglotapi.service;

import com.smartdiscover.parkinglotapi.model.VehicleInfo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RtoService {

    public VehicleInfo getVehicleInfo(String registrationNum) {

        //REST API call to third-party service to fetch the vehicle info

        VehicleInfo info = new VehicleInfo();
        info.setRegistrationNum(registrationNum);
        //random generation

        if (System.currentTimeMillis() % 2 == 0) {
            info.setMakerName("Tata");
            info.setModelName("Tiago");
            info.setEngineNum("XYZ");
            info.setChassisNum("ABC");
            info.setCanElectricCharge(false);
            info.setType("HATCHBACK");
            info.setRegistrationDate(LocalDate.of(2020, 07, 9));
        } else {
            info.setMakerName("Mahindra");
            info.setModelName("XUV 500");
            info.setEngineNum("XYZABC");
            info.setChassisNum("ABCXYZ");
            info.setCanElectricCharge(false);
            info.setType("SUV");
            info.setRegistrationDate(LocalDate.of(2021, 07, 9));
        }

        return info;
    }

}
