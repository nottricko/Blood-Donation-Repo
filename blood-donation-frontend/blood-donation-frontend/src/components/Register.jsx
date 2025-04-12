import { TextField, Button, Typography, Box } from "@mui/material";
import { Link } from "react-router-dom";
import Header from "./Header";
import "../styles/Register.css";

const Register = () => {
  return (
    <>
      <Header />
      <Box className="register-container">
        <Typography variant="h4" className="register-title">Register</Typography>
        <Box component="form" className="register-form">
          <TextField label="Full Name" variant="outlined" fullWidth margin="normal" />
          <TextField label="Email" variant="outlined" fullWidth margin="normal" />
          <TextField label="Password" variant="outlined" type="password" fullWidth margin="normal" />
          <TextField label="Confirm Password" variant="outlined" type="password" fullWidth margin="normal" />
          <Button variant="contained" color="primary" fullWidth className="register-button">
            Register
          </Button>
        </Box>
        <Typography variant="body1" className="login-text">
          Already have an account? <Link to="/login" className="login-link">Login here</Link>
        </Typography>
      </Box>
    </>
  );
};

export default Register;
