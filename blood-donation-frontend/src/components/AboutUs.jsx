import { Container, Typography } from "@mui/material";
import Header from "./Header";
import "../styles/AboutUs.css";

const AboutUs = () => {
  return (
    <>
      <Header />
      <Container maxWidth="false" className="about-page">
        <Typography variant="h3">About Us</Typography>
        <Typography variant="h6" sx={{ mt: 2 }}>
          Learn more about our mission to save lives through blood donation.
        </Typography>
      </Container>
    </>
  );
};

export default AboutUs;
