import React from "react";
import logo from "../pictures/logo-blooddonation.png";

const Header = () => {
  return (
    <header style={styles.header}>
      <a href="/" style={styles.logoContainer}>
        <img src={logo} alt="Logo" style={styles.logo} />
        <span style={styles.title}>Blood Donation</span>
      </a>
      <nav>
        <ul style={styles.navList}>
          <li><a href="/about" style={styles.link}>About Us</a></li>
          <li><a href="/contact" style={styles.link}>Contact Us</a></li>
          <li><a href="/login" style={styles.link}>Login</a></li>
        </ul>
      </nav>
    </header>
  );
};

const styles = {
  header: {
    background: "white",
    color: "#d32f2f",
    padding: "20px 20px",
    display: "flex",
    justifyContent: "space-between",
    alignItems: "center",
    borderBottom: "2px solid #d32f2f",
  },
  logoContainer: {
    display: "flex",
    alignItems: "center",
    textDecoration: "none",
  },
  logo: {
    width: "40px",
    height: "40px",
    marginRight: "10px",
  },
  title: {
    color: "#d32f2f",
    fontSize: "24px",
    fontWeight: "bold",
  },
  navList: {
    listStyle: "none",
    padding: 0,
    margin: 0,
    display: "flex",
    gap: "20px",
  },
  link: {
    color: "#d32f2f",
    textDecoration: "none",
    fontSize: "16px",
    fontWeight: "bold",
  },
};

export default Header;
