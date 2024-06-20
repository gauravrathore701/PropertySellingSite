// Utilities
import { Route, Routes } from 'react-router-dom';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css'
import './App.css';

// Pages
import AddProperty from './Pages/AddProperty';
import ContactUs from './Pages/ContactUs';
import EditProperty from './Pages/EditProperty';
import LoginPage from './Pages/LoginPage';
import RegisterPage from './Pages/RegisterPage';
import Footer from './Components/Footer';
import EditProfile from './Pages/EditProfile';

function App() {
  return (
    <div className="App">
      <Routes>
      <Route path="/" element={<LoginPage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/edit-user" element={<EditProfile />} />
        <Route path="/register" element={<RegisterPage />} />
        <Route path='/contact-us' element={<ContactUs/>} />
        <Route path='/edit-property' element={<EditProperty />} />
        <Route path='/add-property' element={<AddProperty/>} />
      </Routes>
      <Footer/>
      <ToastContainer />     
    </div>
  );
}

export default App;
