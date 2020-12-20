package com.project.continental.OwnerService.Service;

import com.project.continental.OwnerService.Model.Report;
import com.project.continental.OwnerService.Model.VehicleDetails;
import com.project.continental.OwnerService.Repository.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    /**
     * Service class for fetching and saving vehicle details
     */

    private static final Logger logger = LoggerFactory.getLogger(VehicleService.class);

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    RestTemplate restTemplate;


    public List<VehicleDetails> getAll() {
        List<VehicleDetails> vehicleDetails=new ArrayList<>();
        try {
            vehicleDetails=vehicleRepository.findAll();
            logger.info("fetching all vehicle details to database");
        } catch (Exception e) {
            logger.info("Error fetching data");
        }
        return vehicleDetails;
    }

    public Optional<VehicleDetails> getByRegNo(String regno) {
        Optional<VehicleDetails> vehicleDetails = Optional.of(new VehicleDetails());
        try {
            vehicleDetails = vehicleRepository.findById(regno);
            logger.info("fetching vehicle details from database");
        } catch (Exception e) {
            logger.error("Error fetching vehicle details");
        }
       return  vehicleDetails;
    }

    public void addVehicle(VehicleDetails vehicleDetails) {
        try {
            vehicleRepository.save(vehicleDetails);
            logger.info("Saving vehicle details to database");
        } catch (Exception e) {
            logger.error("Error saving vehicle to database");
        }
    }

    public Report getReportByReg(String regno) {
        Report report=new Report();
        try {
            logger.info("Calling police service for violation report");
            report=restTemplate.getForObject("http://localhost:8084/api/v1/getReport/" + regno, Report.class);
        } catch (Exception e) {
            logger.error("Error fetching report");
        }
        return report;
    }
}
