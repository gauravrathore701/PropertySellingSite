import './App.css';
import AddProperty from './Pages/AddProperty';
import Footer from './Components/Footer';
import ContactUs from './Pages/ContactUs';
import EditProperty from './Pages/EditProperty';
import LoginPage from './Pages/LoginPage';

function App() {
  return (
    <div className="App">
        {/* <LoginPage /> */}
        <AddProperty />
        {/* <EditProperty /> */}
        <ContactUs />
        <Footer />
    </div>
  );
}

export default App;
