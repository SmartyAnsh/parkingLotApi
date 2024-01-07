package com.smartdiscover.parkinglotapi.repository;

import com.smartdiscover.parkinglotapi.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {

    Vehicle findByRegistrationNum(String registrationNum);

}
