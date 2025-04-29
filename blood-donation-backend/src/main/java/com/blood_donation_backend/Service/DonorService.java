package com.blood_donation_backend.Service;

import com.blood_donation_backend.Entity.DonorEntity;
import com.blood_donation_backend.Repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonorService {

    @Autowired
    private DonorRepository donorRepository;

    // Save or update a donor
    public DonorEntity saveDonor(DonorEntity donorEntity) {
        return donorRepository.save(donorEntity);
    }

    // Get all donors
    public List<DonorEntity> getAllDonors() {
        return donorRepository.findAll();
    }

    // Get a donor by ID
    public Optional<DonorEntity> getDonorById(int donorId) {
        return donorRepository.findById(donorId);
    }

    // Find donor by user ID (since user_id is mapped in DonorEntity)
    public DonorEntity findByUserId(int userId) {
        return donorRepository.findByUser_UserId(userId);
    }

    // Delete donor by ID
    public void deleteDonor(int donorId) {
        donorRepository.deleteById(donorId);
    }
}
