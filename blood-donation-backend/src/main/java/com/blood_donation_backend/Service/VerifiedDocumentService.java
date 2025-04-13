package com.blood_donation_backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blood_donation_backend.Entity.VerifiedDocumentEntity;
import com.blood_donation_backend.Repository.VerifiedDocumentRepository;

@Service
public class VerifiedDocumentService {

    @Autowired
    private VerifiedDocumentRepository repo;

    // Create
    public VerifiedDocumentEntity createDocument(VerifiedDocumentEntity document) {
        return repo.save(document);
    }

    // Read All
    public List<VerifiedDocumentEntity> getAllDocuments() {
        return repo.findAll();
    }

    // Read by ID
    public VerifiedDocumentEntity getDocumentById(int id) {
        Optional<VerifiedDocumentEntity> optionalDoc = repo.findById(id);
        return optionalDoc.orElse(null); // or throw a custom exception if you prefer
    }

    // Update
    public VerifiedDocumentEntity updateDocument(int id, VerifiedDocumentEntity newData) {
        VerifiedDocumentEntity existing = getDocumentById(id);
        if (existing != null) {
            existing.setRecipientId(newData.getRecipientId());
            existing.setHospitalId(newData.getHospitalId());
            existing.setDoctorName(newData.getDoctorName());
            existing.setDocumentType(newData.getDocumentType());
            existing.setUploadPath(newData.getUploadPath());
            existing.setApprovalStatus(newData.getApprovalStatus());
            existing.setVerificationDate(newData.getVerificationDate());
            return repo.save(existing);
        }
        return null;
    }

    // Delete
    public String deleteDocument(int id) {
        VerifiedDocumentEntity doc = getDocumentById(id);
        if (doc != null) {
            repo.deleteById(id);
            return "Document with ID " + id + " has been deleted.";
        } else {
            return "Document ID not found.";
        }
    }
}