import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import AboutUs from './components/AboutUs';
import ContactUs from './components/ContactUs';
import LandingPage from './components/LandingPage';
import Login from './components/Login';
import Register from './components/Register';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<LandingPage />} />
        <Route path="/about" element={<AboutUs />} />
        <Route path="/contact" element={<ContactUs />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
      </Routes>
    </Router>
  );
}

export default App;
