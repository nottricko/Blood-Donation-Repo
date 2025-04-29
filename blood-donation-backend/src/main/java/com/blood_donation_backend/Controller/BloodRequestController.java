package com.blood_donation_backend.Controller;

import com.blood_donation_backend.Entity.BloodRequestEntity;
import com.blood_donation_backend.DTO.BloodRequest;
import com.blood_donation_backend.Service.BloodRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/blood-requests")
public class BloodRequestController {

    @Autowired
    private BloodRequestService bloodRequestService;

    // Create a new blood request

    @PostMapping
    public ResponseEntity<BloodRequestEntity> createBloodRequest(@RequestBody BloodRequest bloodRequestDTO) {
        // Use the mapping method from the service to keep your controller clean
        BloodRequestEntity bloodRequestEntity = bloodRequestService.mapDtoToEntity(bloodRequestDTO);

        // Save the request
        BloodRequestEntity savedBloodRequest = bloodRequestService.saveBloodRequest(bloodRequestEntity);

        return ResponseEntity.ok(savedBloodRequest);
    }

}
