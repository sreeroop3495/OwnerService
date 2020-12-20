package com.project.continental.OwnerService.Repository;

import com.project.continental.OwnerService.Model.VehicleDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends  JpaRepository<VehicleDetails,String>{


}
