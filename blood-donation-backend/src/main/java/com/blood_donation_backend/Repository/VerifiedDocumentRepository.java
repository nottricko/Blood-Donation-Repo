package com.blood_donation_backend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blood_donation_backend.Entity.VerifiedDocumentEntity;

@Repository
public interface VerifiedDocumentRepository extends JpaRepository<VerifiedDocumentEntity, Integer> {
    List<VerifiedDocumentEntity> findByApprovalStatus(String status); // Optional: for filtering
}