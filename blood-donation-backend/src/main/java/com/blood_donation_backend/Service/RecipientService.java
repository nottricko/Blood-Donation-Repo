package com.dioquino.demo.service;

import com.dioquino.demo.Entity.RecipientEntity;
import com.dioquino.demo.Repository.RecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RecipientService {

    @Autowired
    private RecipientRepository recipientRepository;

    // Save or update a recipient
    public RecipientEntity saveRecipient(RecipientEntity recipientEntity) {
        return recipientRepository.save(recipientEntity);
    }

    // Get all recipients
    public List<RecipientEntity> getAllRecipients() {
        return recipientRepository.findAll();
    }

    // Get recipient by ID
    public Optional<RecipientEntity> getRecipientById(int recipientId) {
        return recipientRepository.findById(recipientId);
    }

    // Find recipients by dateNeededBy
    public List<RecipientEntity> findRecipientsByDateNeededBy(Date dateNeededBy) {
        return recipientRepository.findByDateNeededBy(dateNeededBy);
    }

    // Delete recipient by ID
    public void deleteRecipient(int recipientId) {
        recipientRepository.deleteById(recipientId);
    }
}
