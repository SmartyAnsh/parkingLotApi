package com.smartdiscover.parkinglotapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.smartdiscover.parkinglotapi.repository")
public class ParkingLotApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkingLotApiApplication.class, args);
    }

}
