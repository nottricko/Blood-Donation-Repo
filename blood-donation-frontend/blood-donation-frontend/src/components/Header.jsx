import React from "react";
import logo from "../pictures/blood-donation-logo.png";
import "../styles/Header.css";
import { NavLink } from "react-router-dom";

const Header = () => {
  return (
    <header className="blood-donation-header">
        <div className="blood-donation-header-logo">
          <img src={logo} alt="Logo" className="logo" />
          <div className="logo-text-group">
            <span className="logo-line-1">BLOOD DONATION</span>
            <span className="logo-line-2">MANAGEMENT SYSTEM</span>
          </div>
        </div>
      <nav className="nav-bar">
      <NavLink to="/" className="blood-donation-header-nav" activeclassname="active">HOME</NavLink>
      <NavLink to="/request" className="blood-donation-header-nav" activeclassname="active">REQUEST BLOOD</NavLink>
      <NavLink to="/donate" className="blood-donation-header-nav" activeclassname="active">DONATE BLOOD</NavLink>
      <NavLink to="/about" className="blood-donation-header-nav" activeclassname="active">ABOUT US</NavLink>
      <NavLink to="/login" className="login-button" activeclassname="active">LOGIN</NavLink>
    </nav>
    </header>
  );
};

export default Header;
