package com.blood_donation_backend.Controller;


import com.blood_donation_backend.Entity.BloodRequestEntity;
import com.blood_donation_backend.Service.BloodRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospital/blood-requests")
public class HospitalBloodRequestController {

    @Autowired
    private BloodRequestService bloodRequestService;

    // Get all blood requests for the hospital to view
    @GetMapping
    public ResponseEntity<List<BloodRequestEntity>> getAllBloodRequests() {
        List<BloodRequestEntity> requests = bloodRequestService.getAllRequests();
        return ResponseEntity.ok(requests);
    }

    // Update the status of a blood request (Approve/Decline)
    @PutMapping("/update-status/{id}")
    public ResponseEntity<String> updateBloodRequestStatus(@PathVariable Long id, @RequestParam String status) {
        // Validate the status (should be "Approved" or "Declined")
        if ("Approved".equalsIgnoreCase(status) || "Declined".equalsIgnoreCase(status)) {
            bloodRequestService.updateBloodRequestStatus(id, status); // Update the status
            return ResponseEntity.ok("Blood request status updated successfully.");
        } else {
            return ResponseEntity.badRequest().body("Invalid status. Use 'Approved' or 'Declined'");
        }
    }
}

