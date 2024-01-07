package com.smartdiscover.parkinglotapi.repository;

import com.smartdiscover.parkinglotapi.entity.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, UUID> {
}
