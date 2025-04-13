package com.blood_donation_backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blood_donation_backend.Entity.DonationEntity;
import com.blood_donation_backend.Service.DonationService;



@RestController
@RequestMapping("/api/donations")
@CrossOrigin(origins = "http://localhost:3000")
public class DonationController {

    @Autowired
    private DonationService service;

    // Create
    @PostMapping("/create")
    public DonationEntity create(@RequestBody DonationEntity donation) {
        return service.createDonation(donation);
    }

    // Read All
    @GetMapping("/all")
    public List<DonationEntity> getAll() {
        return service.getAllDonations();
    }

    // Read by ID
    @GetMapping("/{id}")
    public DonationEntity getById(@PathVariable int id) {
        return service.getDonationById(id);
    }

    // Update
    @PutMapping("/update/{id}")
    public DonationEntity update(@PathVariable int id, @RequestBody DonationEntity newData) {
        return service.updateDonation(id, newData);
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        return service.deleteDonation(id);
    }
}