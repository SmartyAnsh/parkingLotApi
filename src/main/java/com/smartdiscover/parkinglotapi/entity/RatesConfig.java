package com.smartdiscover.parkinglotapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class RatesConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    //TODO add properties

}
