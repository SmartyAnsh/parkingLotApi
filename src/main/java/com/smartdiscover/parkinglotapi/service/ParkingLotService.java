package com.smartdiscover.parkinglotapi.service;

import com.smartdiscover.parkinglotapi.entity.ParkingOrder;
import com.smartdiscover.parkinglotapi.entity.ParkingSpace;
import com.smartdiscover.parkinglotapi.entity.Payment;
import com.smartdiscover.parkinglotapi.entity.Vehicle;
import com.smartdiscover.parkinglotapi.model.EntryRequestModel;
import com.smartdiscover.parkinglotapi.model.ExitRequestModel;
import com.smartdiscover.parkinglotapi.repository.ParkingOrderRepository;
import com.smartdiscover.parkinglotapi.repository.ParkingSpaceRepository;
import com.smartdiscover.parkinglotapi.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class ParkingLotService {

    @Autowired
    private ParkingSpaceRepository parkingSpaceRepository;

    @Autowired
    private ParkingOrderRepository parkingOrderRepository;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private PaymentRepository paymentRepository;

    public String entry(EntryRequestModel requestModel) throws Exception {
        //fetch vehicle info
        Vehicle vehicle = vehicleService.saveVehicle(requestModel.getRegistrationNum());

        if (checkAvailability(vehicle)) {
            ParkingSpace parkingSpace = allocateParkingSpace(vehicle);

            //create parking order
            ParkingOrder parkingOrder = new ParkingOrder(vehicle, parkingSpace);
            System.out.println(requestModel.getRegistrationNum() + " : " + parkingOrder.getParkingOrderNum());
            parkingOrderRepository.save(parkingOrder);

        } else {
            throw new Exception("No parking space available");
        }

        return "OK";
    }

    public String exit(ExitRequestModel requestModel) throws Exception {
        //fetch parking order
        ParkingOrder parkingOrder = parkingOrderRepository.
                findByVehicleRegistrationNumOrParkingOrderNum(requestModel.getRegistrationNum(), requestModel.getParkingOrderNum());

        //check for payment if it's already paid
        if (null == parkingOrder.getPayment() || !parkingOrder.getPayment().isPaid()) {
            parkingOrder.setExit(LocalDateTime.now());
            calculatePaymentAmount(parkingOrder);

            return parkingOrder.getPayment().getAmount().toString();
        }

        return "OK";
    }


    //TODO implement check availability
    private boolean checkAvailability(Vehicle vehicle) {
        return true;
    }

    //TODO implement allocate parking space
    private ParkingSpace allocateParkingSpace(Vehicle vehicle) {
        return parkingSpaceRepository.findAll().get(0);
    }

    //TODO implement payment calculation
    private void calculatePaymentAmount(ParkingOrder parkingOrder) {
        Payment payment = new Payment(parkingOrder);
        payment.setAmount(new BigDecimal("100"));
        parkingOrder.setPayment(payment);
        paymentRepository.save(payment);
    }

}
