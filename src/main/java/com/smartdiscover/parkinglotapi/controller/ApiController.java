package com.smartdiscover.parkinglotapi.controller;

import com.smartdiscover.parkinglotapi.entity.ParkingLot;
import com.smartdiscover.parkinglotapi.entity.ParkingSpace;
import com.smartdiscover.parkinglotapi.entity.SpaceType;
import com.smartdiscover.parkinglotapi.entity.Vehicle;
import com.smartdiscover.parkinglotapi.model.EntryRequestModel;
import com.smartdiscover.parkinglotapi.model.ExitRequestModel;
import com.smartdiscover.parkinglotapi.repository.*;
import com.smartdiscover.parkinglotapi.service.ParkingLotService;
import com.smartdiscover.parkinglotapi.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Autowired
    private ParkingOrderRepository parkingOrderRepository;

    @Autowired
    private ParkingSpaceRepository parkingSpaceRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private RatesConfigRepository ratesConfigRepository;

    @Autowired
    private SpaceTypeRepository spaceTypeRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ParkingLotService parkingLotService;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/bootstrap")
    public String bootstrapData() {
        //create space types
        List<SpaceType> spaceTypes = new ArrayList<>();
        spaceTypes.add(new SpaceType("SMALL", false, Vehicle.VehicleSize.SMALL));
        spaceTypes.add(new SpaceType("SMALL_ELECTRIC", true, Vehicle.VehicleSize.SMALL));
        spaceTypes.add(new SpaceType("MEDIUM", false, Vehicle.VehicleSize.MEDIUM));
        spaceTypes.add(new SpaceType("MEDIUM_ELECTRIC", true, Vehicle.VehicleSize.MEDIUM));
        spaceTypes.add(new SpaceType("LARGE", false, Vehicle.VehicleSize.LARGE));
        spaceTypes.add(new SpaceType("LARGE_ELECTRIC", true, Vehicle.VehicleSize.LARGE));
        spaceTypeRepository.saveAll(spaceTypes);

        //create parking lot
        ParkingLot parkingLot = new ParkingLot("P27", "Hoogoorddreef 38, 1102 NH");
        parkingLotRepository.save(parkingLot);

        //create parking spaces
        ParkingSpace space101 = new ParkingSpace("101", spaceTypeRepository.findByTypeName("SMALL"), parkingLot);
        ParkingSpace space102 = new ParkingSpace("102", spaceTypeRepository.findByTypeName("SMALL_ELECTRIC"), parkingLot);
        ParkingSpace space103 = new ParkingSpace("103", spaceTypeRepository.findByTypeName("MEDIUM"), parkingLot);
        ParkingSpace space104 = new ParkingSpace("104", spaceTypeRepository.findByTypeName("MEDIUM_ELECTRIC"), parkingLot);
        ParkingSpace space105 = new ParkingSpace("105", spaceTypeRepository.findByTypeName("LARGE"), parkingLot);
        ParkingSpace space106 = new ParkingSpace("106", spaceTypeRepository.findByTypeName("LARGE_ELECTRIC"), parkingLot);

        parkingSpaceRepository.saveAll(Arrays.asList(space101, space102, space103, space104, space105, space106));

        return "OK";
    }

    @PostMapping(value = "/entry", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String entry(@RequestBody EntryRequestModel requestModel) throws Exception {
        return parkingLotService.entry(requestModel);
    }

    @PostMapping(value = "/exit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String exit(@RequestBody ExitRequestModel requestModel) throws Exception {
        return parkingLotService.exit(requestModel);
    }

    @PostMapping(value = "/exit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String pay(@RequestBody ExitRequestModel requestModel) throws Exception {
        paymentService.payParkingAmount
                (parkingOrderRepository.
                        findByVehicleRegistrationNumOrParkingOrderNum(
                                requestModel.getRegistrationNum(), requestModel.getParkingOrderNum()));

        return "OK";
    }

}
