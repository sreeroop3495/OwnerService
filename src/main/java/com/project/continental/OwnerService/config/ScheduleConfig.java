package com.project.continental.OwnerService.config;

import com.project.continental.OwnerService.Model.Report;
import com.project.continental.OwnerService.Model.ViolationRecord;
import com.project.continental.OwnerService.Service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleConfig {

    /**
     * To schedule a task to send report to each owners
     */
    @Autowired
    VehicleService vehicleService;

    private static final Logger logger= LoggerFactory.getLogger(ScheduleConfig.class);


    //@Scheduled(cron = "0 0 0 * * MON")
    @Scheduled(fixedDelay = 1000)
    public void sendReport(){
        Report report=new Report();
        //here hardcoded vehicle number, we can use a logic here
        report= vehicleService.getReportByReg("KL57M7570");
        System.out.println(report.getVehicleDetails().getRegno());
        for(ViolationRecord violationRecord: report.getViolationRecord()){
            System.out.println(violationRecord.toString());
        }

        }
    }
