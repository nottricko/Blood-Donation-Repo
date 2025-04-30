import React, { useState } from "react";
import { Container, Typography, TextField, Button, Box, Alert } from "@mui/material";
import axios from "axios";
import Header from "./Header";
import "../styles/DonateBlood.css"; 

const DonateBlood = () => {
  const [formData, setFormData] = useState({
    donorName: "",
    donorAddress: "",
    donorPhone: "",
    donorEmail: "",
    bloodType: "",
  });

  const [success, setSuccess] = useState(false);
  const [error, setError] = useState(false);

  const handleChange = (e) => {
    setFormData({...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post("http://localhost:8080/api/donations/create", formData);
      setSuccess(true);
      setError(false);
      setFormData({
        donorName: "",
        donorAddress: "",
        donorPhone: "",
        donorEmail: "",
        bloodType: "",
      });
    } catch (error) {
      setError(true);
      setSuccess(false);
    }
  };

  return (
    <>
      <Header />
      <Container maxWidth="sm" className="donate-page">
        <Typography variant="h3" className="donate-title">Donate Blood</Typography>
        <Typography variant="h6" className="donate-subtitle">
          Your donation can save lives! Fill out the form below.
        </Typography>

        {success && <Alert severity="success" sx={{ mt: 2 }}>Thank you for donating! We'll contact you soon.</Alert>}
        {error && <Alert severity="error" sx={{ mt: 2 }}>Submission failed. Please try again.</Alert>}

        <Box component="form" onSubmit={handleSubmit} className="donate-form">
          <TextField name="donorName" label="Full Name" variant="outlined" fullWidth margin="normal" value={formData.donorName} onChange={handleChange} required />
          <TextField name="donorAddress" label="Address" variant="outlined" fullWidth margin="normal" value={formData.donorAddress} onChange={handleChange} required />
          <TextField name="donorPhone" label="Phone Number" variant="outlined" fullWidth margin="normal" value={formData.donorPhone} onChange={handleChange} required />
          <TextField name="donorEmail" label="Email" variant="outlined" fullWidth margin="normal" value={formData.donorEmail} onChange={handleChange} required />
          <TextField name="bloodType" label="Blood Type" variant="outlined" fullWidth margin="normal" value={formData.bloodType} onChange={handleChange} required />
          
          <Button variant="contained" color="error" fullWidth type="submit" sx={{ mt: 2 }}>
            Submit Donation
          </Button>
        </Box>
      </Container>
    </>
  );
};

export default DonateBlood;
