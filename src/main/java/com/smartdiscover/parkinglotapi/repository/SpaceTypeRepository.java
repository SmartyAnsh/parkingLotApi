package com.smartdiscover.parkinglotapi.repository;

import com.smartdiscover.parkinglotapi.entity.SpaceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpaceTypeRepository extends JpaRepository<SpaceType, UUID> {

    SpaceType findByTypeName(String typeName);
}
