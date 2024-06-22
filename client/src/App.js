// Utilities
import { Route, Routes } from "react-router-dom";
import { ToastContainer } from "react-toastify";
import "./App.css";

// Pages
import AddProperty from "./Pages/AddProperty";
import ContactUs from "./Pages/ContactUs";
import EditProperty from "./Pages/EditProperty";
import LoginPage from "./Pages/LoginPage";
import ProductCard from "./Components/ProductCard";
import List from "./Pages/DemoListPages";
import WishlistPage from "./Pages/Wishlist";
import RegisterPage from "./Pages/RegisterPage";
import EditProfile from "./Pages/EditProfile"

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<List />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/register-page" element={<RegisterPage />} />
        <Route path="/edit-page" element={<EditProfile/>} />
        <Route path="/contact-us" element={<ContactUs />} />
        <Route path="/edit-property" element={<EditProperty />} />
        <Route path="/add-property" element={<AddProperty />} />
        <Route path="/product-card" element={<ProductCard />} />
        <Route path="/wishlist" element={<WishlistPage />} />
      </Routes>
      <ToastContainer />
    </div>
  );
}

export default App;
