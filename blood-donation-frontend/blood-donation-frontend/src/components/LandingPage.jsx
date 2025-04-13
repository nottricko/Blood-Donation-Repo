import React from "react";
import { Container, Typography, Grid } from "@mui/material";
import { useNavigate } from "react-router-dom";
import Header from "./Header";
import "../styles/LandingPage.css";

import heartBag from "../pictures/blood-donation-heartbag.png";
import doctorIllustration from "../pictures/blood-donation-doctorPatient.png";
import Donation from "../pictures/3lives.png";
import Arm from "../pictures/blood-arm.png";
import Chart from "../pictures/blood-type-chart.png";
const LandingPage = () => {
  const navigate = useNavigate();

  return (
    <>
      <Header />
      <Container maxWidth="lg" className="landing-page">
        <div className="landing-hero">
          <img src={heartBag} alt="Blood Bag" className="hero-left-img" />
          <div className="hero-title">
            <Typography variant="h3" className="hero-red">BLOOD DONATION</Typography>
            <Typography variant="h3" className="hero-black">MANAGEMENT SYSTEM</Typography>
          </div>
          <img src={doctorIllustration} alt="Doctor" className="hero-right-img" />
        </div>

        <Grid container spacing={3} justifyContent="center" className="hero-buttons">
          <Grid item>
            <div className="hero-card red" onClick={() => navigate("/availability")}>
              BLOOD AVAILABILITY<br />SEARCH
            </div>
          </Grid>
          <Grid item>
            <div className="hero-card red-dark" onClick={() => navigate("/blood-types")}>
              BLOOD TYPES AND<br />DETAILS
            </div>
          </Grid>
          <Grid item>
            <div className="hero-card brown" onClick={() => navigate("/search-donor")}>
              SEARCH FOR<br />BLOOD DONOR
            </div>
          </Grid>
          <Grid item>
            <div className="hero-card red" onClick={() => navigate("/register-volunteer")}>
              REGISTER AS A<br />VOLUNTEER
            </div>
          </Grid>
        </Grid>

        <div className="donation-info-section">
          <div className="donation-fact-wrapper">
            <img src={Donation} alt="Save Lives Fact" className="donation-fact-image" />
          </div>
        </div>


        <div className="blood-type-section">
          <div className="blood-image">
            <img src={Arm} alt="Blood Donation Arm" />
          </div>
          <div className="compatibility-image">
            <img src={Chart} alt="Blood Type Compatibility Chart" />
          </div>
        </div>


        <div className="donation-description">
            <h3>TYPES OF DONATION</h3>
            <p>
              Did you know your blood is made up of powerful components? Red blood cells, platelets, and plasma—
              each one can save lives in different ways. When you donate, your blood is carefully separated so it can help
              more people. Just one donation can make a difference for up to four lives. A small act from you, a big impact for others.
            </p>
        </div>


      </Container>
      <footer className="basic-footer">
          <div className="footer-content">
            <p>&copy; {new Date().getFullYear()} Blood Donation Management System. All rights reserved.</p>
            <div className="footer-links">
              <a href="/about">About Us</a>
              <a href="/contact">Contact</a>
              <a href="/privacy">Privacy Policy</a>
            </div>
          </div>
        </footer>
    </>
  );
};

export default LandingPage;
