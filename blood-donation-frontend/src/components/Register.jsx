import { TextField, Button, Typography, Box } from "@mui/material";
import { Link } from "react-router-dom";
import Header from "./Header";
import "../styles/Register.css";
import { useState } from "react";
import axios from "axios";

const Register = () => {
  const [formData, setFormData] = useState({
    firstName: "",
    lastName: "",
    email: "",
    contactNumber: "",
    address: "",
    password: "",
    confirmPassword: "",
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (formData.password !== formData.confirmPassword) {
      alert("Passwords do not match!");
      return;
    }

    try {
      const payload = {
        firstName: formData.firstName,
        lastName: formData.lastName,
        email: formData.email,
        contactNumber: formData.contactNumber,
        address: formData.address,
        password: formData.password,
      };

      const response = await axios.post('http://localhost:8080/api/users/register', payload);
      console.log(response.data);
      alert("Registration successful!");

      // Optional: Clear the form
      setFormData({
        firstName: "",
        lastName: "",
        email: "",
        contactNumber: "",
        address: "",
        password: "",
        confirmPassword: "",
      });

    } catch (error) {
      console.error(error);
      if (error.response) {
        console.error("Backend error:", error.response.data);
        alert(`Registration failed: ${error.response.data}`);
      } else {
        alert("Registration failed. Please try again.");
      }
    }
  };

  return (
    <>
      <Header />
      <Box className="register-container">
        <Typography variant="h4" className="register-title">Sign Up</Typography>
        <Box component="form" className="register-form" onSubmit={handleSubmit}>
          <TextField 
            label="First Name" 
            variant="outlined" 
            fullWidth 
            margin="normal" 
            name="firstName" 
            value={formData.firstName}
            onChange={handleChange}
          />
          <TextField 
            label="Last Name" 
            variant="outlined" 
            fullWidth 
            margin="normal" 
            name="lastName"
            value={formData.lastName}
            onChange={handleChange}
          />
          <TextField 
            label="Email" 
            variant="outlined" 
            fullWidth 
            margin="normal" 
            name="email"
            value={formData.email}
            onChange={handleChange}
          />
          <TextField 
            label="Phone Number" 
            variant="outlined" 
            fullWidth 
            margin="normal" 
            name="contactNumber"
            value={formData.contactNumber}
            onChange={handleChange}
          />
          <TextField 
            label="Address" 
            variant="outlined" 
            fullWidth 
            margin="normal" 
            name="address"
            value={formData.address}
            onChange={handleChange}
          />
          <TextField 
            label="Password" 
            variant="outlined" 
            type="password" 
            fullWidth 
            margin="normal" 
            name="password"
            value={formData.password}
            onChange={handleChange}
          />
          <TextField 
            label="Confirm Password" 
            variant="outlined" 
            type="password" 
            fullWidth 
            margin="normal" 
            name="confirmPassword"
            value={formData.confirmPassword}
            onChange={handleChange}
          />
          <Button 
            type="submit"
            variant="contained" 
            color="primary" 
            fullWidth 
            className="register-button"
          >
            Confirm
          </Button>
        </Box>
        <Typography variant="body1" className="login-text">
          Already have an account? <Link to="/login" className="login-link">Login</Link>
        </Typography>
      </Box>
    </>
  );
};

export default Register;
