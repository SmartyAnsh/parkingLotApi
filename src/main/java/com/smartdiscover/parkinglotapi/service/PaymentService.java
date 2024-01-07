package com.smartdiscover.parkinglotapi.service;

import com.smartdiscover.parkinglotapi.entity.ParkingOrder;
import com.smartdiscover.parkinglotapi.repository.ParkingOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentService {

    @Autowired
    private ParkingOrderRepository parkingOrderRepository;

    public void payParkingAmount(ParkingOrder parkingOrder) {
        parkingOrder.getPayment().setPaid(true);
        parkingOrder.getPayment().setDatePaid(LocalDateTime.now());
        parkingOrderRepository.save(parkingOrder);
    }

}
