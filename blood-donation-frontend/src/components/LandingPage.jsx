import { Container, Typography } from "@mui/material";
import Header from "./Header";
import "../styles/LandingPage.css"; 

const LandingPage = () => {
  return (
    <>
      <Header />
      <Container maxWidth="false" className="landing-page">
        <Typography variant="h3">Welcome to Blood Donation</Typography>
        <Typography variant="h6" sx={{ mt: 2 }}>
          Save lives by donating blood. Sign up today!
        </Typography>
      </Container>
    </>
  );
};

export default LandingPage;
