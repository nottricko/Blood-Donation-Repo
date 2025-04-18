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
        BloodRequestEntity bloodRequestEntity = new BloodRequestEntity();

        // Set fields from DTO to Entity
        bloodRequestEntity.setPatientName(bloodRequestDTO.getPatientName());
        bloodRequestEntity.setBloodType(bloodRequestDTO.getBloodType());
        bloodRequestEntity.setRepresentativeName(bloodRequestDTO.getRepresentativeName());
        bloodRequestEntity.setRepresentativeRelation(bloodRequestDTO.getRelationshipWithPatient());

        // Use the requestDate from DTO or set it to current date if not provided
        if (bloodRequestDTO.getRequestDate() != null) {
            bloodRequestEntity.setRequestDate(bloodRequestDTO.getRequestDate());
        } else {
            bloodRequestEntity.setRequestDate(new Date());  // Set current date if no date provided
        }



        // Save the request
        BloodRequestEntity savedBloodRequest = bloodRequestService.saveBloodRequest(bloodRequestEntity);

        return ResponseEntity.ok(savedBloodRequest);
    }
}
