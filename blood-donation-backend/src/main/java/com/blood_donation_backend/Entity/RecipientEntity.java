package com.blood_donation_backend.Entity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "recipient")
public class RecipientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipientId;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private UserEntity user;

    private String bloodTypeNeeded;
    private String medicalCondition;

    @Temporal(TemporalType.DATE)
    private Date dateNeededBy;

    private String urgencyLevel;

    // No-args constructor
    public RecipientEntity() {}

    // Constructor for easy Postman testing
    public RecipientEntity(String bloodTypeNeeded, String medicalCondition,
                           Date dateNeededBy, String urgencyLevel) {
        this.bloodTypeNeeded = bloodTypeNeeded;
        this.medicalCondition = medicalCondition;
        this.dateNeededBy = dateNeededBy;
        this.urgencyLevel = urgencyLevel;
    }

    // Getters and Setters
    public int getRecipientId() { return recipientId; }
    public UserEntity getUser() { return user; }
    public void setUser(UserEntity user) { this.user = user; }
    public String getBloodTypeNeeded() { return bloodTypeNeeded; }
    public void setBloodTypeNeeded(String bloodTypeNeeded) { this.bloodTypeNeeded = bloodTypeNeeded; }
    public String getMedicalCondition() { return medicalCondition; }
    public void setMedicalCondition(String medicalCondition) { this.medicalCondition = medicalCondition; }
    public Date getDateNeededBy() { return dateNeededBy; }
    public void setDateNeededBy(Date dateNeededBy) { this.dateNeededBy = dateNeededBy; }
    public String getUrgencyLevel() { return urgencyLevel; }
    public void setUrgencyLevel(String urgencyLevel) { this.urgencyLevel = urgencyLevel; }
}
