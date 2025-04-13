import { Container, Typography } from "@mui/material";
import Header from "./Header";
import "../styles/ContactUs.css";

const ContactUs = () => {
  return (
    <>
      <Header />
      <Container maxWidth="false" className="contact-page">
        <Typography variant="h3">Contact Us</Typography>
        <Typography variant="h6" sx={{ mt: 2 }}>
          Get in touch with us for more information on how to donate.
        </Typography>
      </Container>
    </>
  );
};

export default ContactUs;
