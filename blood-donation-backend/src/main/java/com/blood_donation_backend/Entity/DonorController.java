package com.dioquino.demo.controller;

import com.dioquino.demo.Entity.DonorEntity;
import com.dioquino.demo.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/donors")
public class DonorController {

    @Autowired
    private DonorService donorService;

    // Save or update donor
    @PostMapping
    public ResponseEntity<DonorEntity> saveDonor(@RequestBody DonorEntity donorEntity) {
        DonorEntity savedDonor = donorService.saveDonor(donorEntity);
        return ResponseEntity.ok(savedDonor);
    }

    // Get all donors
    @GetMapping
    public ResponseEntity<List<DonorEntity>> getAllDonors() {
        List<DonorEntity> donors = donorService.getAllDonors();
        return ResponseEntity.ok(donors);
    }

    // Get donor by ID
    @GetMapping("/{id}")
    public ResponseEntity<DonorEntity> getDonorById(@PathVariable int id) {
        Optional<DonorEntity> donor = donorService.getDonorById(id);
        return donor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Find donor by user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<DonorEntity> getDonorByUserId(@PathVariable int userId) {
        DonorEntity donor = donorService.findByUserId(userId);
        if (donor != null) {
            return ResponseEntity.ok(donor);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete donor by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDonor(@PathVariable int id) {
        donorService.deleteDonor(id);
        return ResponseEntity.noContent().build();
    }
}
