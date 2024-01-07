package com.smartdiscover.parkinglotapi.service;

import com.smartdiscover.parkinglotapi.entity.Vehicle;
import com.smartdiscover.parkinglotapi.model.VehicleInfo;
import com.smartdiscover.parkinglotapi.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    @Autowired
    private RtoService rtoService;

    @Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle saveVehicle(String registrationNum) {

        VehicleInfo vehicleInfo = rtoService.getVehicleInfo(registrationNum);

        Vehicle vehicle = vehicleRepository.findByRegistrationNum(vehicleInfo.getRegistrationNum());

        if (null == vehicle) {
            vehicle = new Vehicle();
        }

        vehicle.setRegistrationNum(vehicleInfo.getRegistrationNum());
        vehicle.setSize(determineVehicleSize(vehicleInfo));
        vehicle.setCanElectricCharge(vehicleInfo.isCanElectricCharge());

        return vehicleRepository.save(vehicle);
    }

    public Vehicle.VehicleSize determineVehicleSize(VehicleInfo vehicleInfo) {
        Vehicle.VehicleSize size = null;
        switch (vehicleInfo.getType().toUpperCase()) {
            case "HATCHBACK":
                size = Vehicle.VehicleSize.SMALL;
                break;
            case "SEDAN":
                if (vehicleInfo.getMakerName().equalsIgnoreCase("TATA")) {
                    size = Vehicle.VehicleSize.MEDIUM;
                } else {
                    size = Vehicle.VehicleSize.LARGE;
                }
                break;
            case "SUV":
                if (vehicleInfo.getMakerName().equalsIgnoreCase("MAHINDRA") &&
                        vehicleInfo.getModelName().toUpperCase().contains("XUV300")) {
                    size = Vehicle.VehicleSize.MEDIUM;
                } else {
                    size = Vehicle.VehicleSize.LARGE;
                }
            default:
                size = Vehicle.VehicleSize.LARGE;
        }

        return size;
    }


}
