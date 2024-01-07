package com.smartdiscover.parkinglotapi.repository;

import com.smartdiscover.parkinglotapi.entity.ParkingOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParkingOrderRepository extends JpaRepository<ParkingOrder, UUID> {

    ParkingOrder findByVehicleRegistrationNumOrParkingOrderNum(String registrationNum, String parkingOrderNum);

}
