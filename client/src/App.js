// Utilities
import { Route, Routes } from 'react-router-dom';
import { ToastContainer } from 'react-toastify';
import './App.css';

// Pages
import AddProperty from './Pages/AddProperty';
import ContactUs from './Pages/ContactUs';
import EditProperty from './Pages/EditProperty';
import LoginPage from './Pages/LoginPage';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/login" element={<LoginPage />} />
        <Route path='/contact-us' element={<ContactUs/>} />
        <Route path='/edit-property' element={<EditProperty />} />
        <Route path='/add-property' element={<AddProperty/>} />
      </Routes>
      <ToastContainer />     
    </div>
  );
}

export default App;
