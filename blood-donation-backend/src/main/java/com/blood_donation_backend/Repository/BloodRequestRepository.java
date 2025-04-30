package com.blood_donation_backend.Repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blood_donation_backend.Entity.BloodRequestEntity;

@Repository
public interface BloodRequestRepository extends JpaRepository<BloodRequestEntity, Long> {

    // Custom queries (if needed)

    // Get all requests for a specific patient (you can also add filtering based on status)

    Optional<BloodRequestEntity> findByRepresentativeName(String representativeName);

    List<BloodRequestEntity> findByPatientName(String patientName);

    // Find by request status (Pending, Approved, Rejected)
    List<BloodRequestEntity> findByStatus(String status);

    // Find by patient ID
    ;
}
