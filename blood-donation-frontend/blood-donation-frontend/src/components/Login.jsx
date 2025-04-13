import { TextField, Button, Typography, Box } from "@mui/material";
import { Link } from "react-router-dom";
import Header from "./Header";
import "../styles/Login.css";

const Login = () => {
  return (
    <>
      <Header />
      <Box className="login-container">
        <Typography variant="h4" className="login-title">Login</Typography>
        <Box component="form" className="login-form">
          <TextField label="Email" variant="outlined" fullWidth margin="normal" />
          <TextField label="Password" variant="outlined" type="password" fullWidth margin="normal" />
          <Button variant="contained" color="primary" fullWidth className="login-button">
            Login
          </Button>
        </Box>
        <Typography variant="body1" className="register-text">
          Don't have an account? <Link to="/register" className="register-link">Register here</Link>
        </Typography>
      </Box>
    </>
  );
};

export default Login;
