package com.blood_donation_backend.Entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "donor")
public class DonorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int donorId;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private UserEntity user;

    @OneToMany(mappedBy = "donor", cascade = CascadeType.ALL)
    private List<DonationEntity> donations;
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