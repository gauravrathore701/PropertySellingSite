import {  Routes, Route } from 'react-router-dom';
import './App.css';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css'
import Footer from './Components/Footer'
import AddProperty from './Pages/AddProperty';
import EditProperty from './Pages/EditProperty';
import ContactUs from './Pages/ContactUs';
// import LoginPage from './Pages/loginPage'
function App() {
  return (
    <div className="App">
      <Routes>
      {/* <Route path='/' element={<LoginPage />}></Route> */}
      <Route path='/' element={<EditProperty />}></Route>
        <Route path='/add' element={<AddProperty />}></Route>
        <Route path='/editprop' element={<EditProperty />}></Route>
        <Route path='/contactus' element={<ContactUs />}></Route>
      </Routes>
      <Footer/>
      <ToastContainer />
    </div>

  );
}

export default App;
