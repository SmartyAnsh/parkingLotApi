package com.smartdiscover.parkinglotapi.repository;

import com.smartdiscover.parkinglotapi.entity.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot, UUID> {
}
