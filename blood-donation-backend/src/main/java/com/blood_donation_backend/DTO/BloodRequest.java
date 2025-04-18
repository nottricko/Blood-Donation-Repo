package com.blood_donation_backend.DTO;


import java.util.Date;

public class BloodRequest{

    private String patientName;
    private String bloodType;
    private String representativeName;
    private String relationshipWithPatient;
    private Date requestDate;
    private String patientAge;
    private String patientMedicalCondition;

    // Getters and Setters

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getRepresentativeName() {
        return representativeName;
    }

    public void setRepresentativeName(String representativeName) {
        this.representativeName = representativeName;
    }

    public String getRelationshipWithPatient() {
        return relationshipWithPatient;
    }

    public void setRelationshipWithPatient(String relationshipWithPatient) {
        this.relationshipWithPatient = relationshipWithPatient;
    }
    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
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
}

