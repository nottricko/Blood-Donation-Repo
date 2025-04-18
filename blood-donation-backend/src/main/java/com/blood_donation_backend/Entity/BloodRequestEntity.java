package com.blood_donation_backend.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "blood_request")
public class BloodRequestEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String bloodType;
    private String patientName;
    private String patientAge;
    private String patientMedicalCondition;
    private String representativeName;
    private String representativeRelation;

    @Lob
    private byte[] documentImage; // to store the image of the document

    private Date requestDate;

    private String status = "Pending"; // New field for the status, initially set to Pending

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(String patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientMedicalCondition() {
        return patientMedicalCondition;
    }

    public void setPatientMedicalCondition(String patientMedicalCondition) {
        this.patientMedicalCondition = patientMedicalCondition;
    }

    public String getRepresentativeName() {
        return representativeName;
    }

    public void setRepresentativeName(String representativeName) {
        this.representativeName = representativeName;
    }

    public String getRepresentativeRelation() {
        return representativeRelation;
    }

    public void setRepresentativeRelation(String representativeRelation) {
        this.representativeRelation = representativeRelation;
    }

    public byte[] getDocumentImage() {
        return documentImage;
    }

    public void setDocumentImage(byte[] documentImage) {
        this.documentImage = documentImage;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
