package com.dioquino.demo.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "User")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    private String address;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private DonorEntity donor;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private RecipientEntity recipient;

    // No-args constructor
    public UserEntity() {}

    // Constructor for easy Postman testing
    public UserEntity(String firstName, String lastName, String email, String contactNumber, String address) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}