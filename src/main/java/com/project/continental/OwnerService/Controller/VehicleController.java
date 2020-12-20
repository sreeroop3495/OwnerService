package com.project.continental.OwnerService.Controller;

import com.project.continental.OwnerService.Model.Report;
import com.project.continental.OwnerService.Model.VehicleDetails;
import com.project.continental.OwnerService.Service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class VehicleController {

    private static final Logger logger= LoggerFactory.getLogger(VehicleController.class);

    /**
     * We are using gateway service at http:/localhost:9000
     */


    @Autowired
    VehicleService vehicleService;

    /**
     * This endpoint is used to get all vehicle details
     * http://localhost:9000/owner/getAll
     */
    @GetMapping("/getAll")
    public List<VehicleDetails> getAll(){
        logger.info("Fetching all vehicle details from database");
        return vehicleService.getAll();

    }

    /**
     * This endpoint is used to get vehicle details by using registration number
     * http://localhost:9000/owner/getVehicleDetails/KL58N500
     */
    @GetMapping("/getVehicleDetails/{regno}")
    public Optional<VehicleDetails> getAll(@PathVariable("regno") String regno){
        return vehicleService.getByRegNo(regno);

    }

    /**
     * This endpoint is used to add vehicle to database
     * http://localhost:9000/owner/addVehicle
     */
    @PostMapping("/addVehicle")
    public void addVehicle(@RequestBody VehicleDetails vehicleDetails){
        try {
            vehicleService.addVehicle(vehicleDetails);
        }catch (Exception e){logger.error("Adding vehicle failed");}
    }


    @GetMapping("/getViolations/{regno}")
    public Report getReport(@PathVariable("regno") String regno){
        return vehicleService.getReportByReg(regno);
    }

}
