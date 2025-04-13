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

import com.blood_donation_backend.Entity.VerifiedDocumentEntity;
import com.blood_donation_backend.Service.VerifiedDocumentService;

@RestController
@RequestMapping("/api/documents")
@CrossOrigin(origins = "http://localhost:3000") //Future reactJS implementation
public class VerifiedDocumentController {

    @Autowired
    private VerifiedDocumentService service;

    // Create
    @PostMapping("/create")
    public VerifiedDocumentEntity create(@RequestBody VerifiedDocumentEntity document) {
        return service.createDocument(document);
    }

    // Read All
    @GetMapping("/all")
    public List<VerifiedDocumentEntity> getAll() {
        return service.getAllDocuments();
    }

    // Read by ID
    @GetMapping("/{id}")
    public VerifiedDocumentEntity getById(@PathVariable int id) {
        return service.getDocumentById(id);
    }
    @GetMapping("/test")
    public String testAPI() {
    return "API is working!";
    }

    // Update
    @PutMapping("/update/{id}")
    public VerifiedDocumentEntity update(@PathVariable int id, @RequestBody VerifiedDocumentEntity newData) {
        return service.updateDocument(id, newData);
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        return service.deleteDocument(id);
    }
}
