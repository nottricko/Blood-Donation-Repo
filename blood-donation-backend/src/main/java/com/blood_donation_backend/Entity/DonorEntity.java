package com.dioquino.demo.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "donor")
public class DonorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int donorId;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private UserEntity user;

    private String bloodType;
    private String healthStatus;

    @Temporal(TemporalType.DATE)  // Stores only date (no time) in database
    private Date lastDonationDate;

    private String availabilityStatus;

    // No-arg constructor
    public DonorEntity() {}

    // Constructor for easy Postman testing
    public DonorEntity(String bloodType, String healthStatus,
                       Date lastDonationDate, String availabilityStatus) {
        this.bloodType = bloodType;
        this.healthStatus = healthStatus;
        this.lastDonationDate = lastDonationDate;
        this.availabilityStatus = availabilityStatus;
    }

    // Getters and Setters
    public int getDonorId() {
        return donorId;
    }

    public UserEntity getUser() {
        return user;
    }
    public void setUser(UserEntity user) {
        this.user = user;
    }
    public String getBloodType() {
        return bloodType;
    }
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
    public String getHealthStatus() {
        return healthStatus;
    }
    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }
    public Date getLastDonationDate() {
        return lastDonationDate;
    }
    public void setLastDonationDate(Date lastDonationDate) {
        this.lastDonationDate = lastDonationDate;
    }
    public String getAvailabilityStatus() {
        return availabilityStatus;
    }
    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }
}