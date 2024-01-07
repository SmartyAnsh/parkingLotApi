package com.smartdiscover.parkinglotapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    private ParkingOrder parkingOrder;

    private BigDecimal amount;

    private boolean isPaid;
    private LocalDateTime datePaid;

    public Payment(ParkingOrder parkingOrder) {
        this.parkingOrder = parkingOrder;
    }

}

