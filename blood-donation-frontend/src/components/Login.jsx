import { useState } from "react";
import { Link } from "react-router-dom";
import CheckCircleIcon from "@mui/icons-material/CheckCircle";
import heartBag from "../pictures/blood-donation-heartbag.png";
import Header from "./Header";
import "../styles/Login.css";
import { TextField, Button, Typography, Box, Modal, Box as ModalBox } from "@mui/material";
import axios from "axios";

const Login = () => {
  const [formData, setFormData] = useState({
    email: "",
    password: "",
  });
  const [openModal, setOpenModal] = useState(false); // State to control modal visibility

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleLogin = async (e) => {
    e.preventDefault();
  
    console.log("Login attempt:", formData); // Log the form data
  
    try {
      const loginPayload = {
        email: formData.email,
        password: formData.password,
      };
  
      const response = await axios.post(
        "http://localhost:8080/api/users/login/manual",
        loginPayload
      );
      console.log("Login response:", response.data); // Log the response data
      alert("Login successful!");
  
      // If login is successful, show the modal
      setOpenModal(true); // This should open the modal
  
    } catch (error) {
      console.error("Login error:", error);
      alert("Login failed. Please check your credentials.");
    }
  };
  

  // Close the modal
  const handleCloseModal = () => {
    setOpenModal(false);
    // Redirect or perform any other action you need after closing the modal
  };

  return (
    <>
      <Header />
      <div className="login-wrapper">
        <div className="login-container">
          <div className="login-form">
            <Typography variant="h4" className="login-title">
              Login
            </Typography>
            <Box component="form" className="login-form-box" onSubmit={handleLogin}>
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
                label="Password"
                variant="outlined"
                type="password"
                fullWidth
                margin="normal"
                name="password"
                value={formData.password}
                onChange={handleChange}
              />
              <Button
                type="submit"
                variant="contained"
                color="primary"
                fullWidth
                className="login-button"
              >
                Login
              </Button>
            </Box>
            <Typography variant="body1" className="register-text">
              Don't have an account?{" "}
              <Link to="/register" className="register-link">
                Register here
              </Link>
            </Typography>
          </div>
        </div>
      </div>

      {/* Success Modal */}
      <Modal open={openModal} onClose={handleCloseModal}>
        <ModalBox
          sx={{
            position: "absolute",
            top: "50%",
            left: "50%",
            transform: "translate(-50%, -50%)",
            bgcolor: "white",
            boxShadow: 24,
            p: 4,
            borderRadius: 2,
            textAlign: "center",
          }}
        >
          <CheckCircleIcon sx={{ fontSize: 60, color: "green" }} />
          <Typography variant="h6" mt={2}>
            Login Successful!
          </Typography>
          <Button
            variant="contained"
            color="primary"
            sx={{ mt: 2 }}
            onClick={handleCloseModal}
          >
            Close
          </Button>
        </ModalBox>
      </Modal>
    </>
  );
};

export default Login;
