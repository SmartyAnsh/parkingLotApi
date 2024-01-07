package com.smartdiscover.parkinglotapi.repository;

import com.smartdiscover.parkinglotapi.entity.RatesConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RatesConfigRepository extends JpaRepository<RatesConfig, UUID> {
}
