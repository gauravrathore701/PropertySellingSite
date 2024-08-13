import Footer from "../Components/Footer";
import Header from "../Components/Header";
import prop1 from "../Assets/Images/Property-1.jpg";
import prop2 from "../Assets/Images/Property-2.jpg";
import prop3 from "../Assets/Images/Property-3.jpg";
import React, { useEffect, useState } from "react";
// import Rating from "@mui/material/Rating";
import Slider from "react-slick";
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import { toast } from "react-toastify";
import { addPropertyWishlist, getPropertyImages, GetSpecficPropertyId } from "../services/property";
import config from "../config";
import { useNavigate, useParams } from "react-router-dom";


function IndividualProperties() {
  const navigate=useNavigate();
  const { propid } = useParams();
  const [Title, setTitle] = useState("Testing Title");
  const [Descpt, setDescpt] = useState(
    "For the first time ever, celebrate the life and music of our friend and The Revolution’s legendary frontman," +
    "groove to some rare Prince songs and get some sleep in The Kid’s bedroom. Wear your finest purple fits, and when you step into history, feel free to unleash your royal rockstar. Stay tuned."
  );
  const [AddressLine1, setAddressLine1] = useState("Pune");
  const [AddressLine2, setAddressLine2] = useState("Pune");
  const [State, setState] = useState("Maharashtra");
  const [District, setDistrict] = useState("Pune");
  const [City, setCity] = useState("Pune");
  const [Pincode, setPincode] = useState("411033");
  const [Type, setType] = useState("Apartment");
  const [Area, setArea] = useState("5000");
  const [Bedroom, setBedroom] = useState("2");
  const [OwnerName, setOwnerName] = useState("Owner");
  const [Bathroom, setBathroom] = useState("2");
  const [Price, setPrice] = useState("2000000");
  const [selectedTags, setSelectedTags] = useState([]);
  const [Images, setImages] = useState([]);
  var images = []
  const settings = {
    dots: true,
    infinite: false,
    slidesToShow: 1,
    slidesToScroll: 1,
    autoplay: true,
    autoplaySpeed: 2000,
    pauseOnHover: true,
  };

  // Back-end Integration Code
  const fetchData = async () => {
    // const id = 9;
    try {
      const result = await GetSpecficPropertyId(propid); // Backend Integration
      if (result.status == 200) {
        const data = result.data;
        return data;
      } else {
        toast.warning('No Such Property Found');
        return null;
      }
    } catch (error) {
      console.error('Error fetching property data:', error);
      toast.error('Error fetching property data');
      return null;
    }
  };

  const fetchImage = async () => {
    // const id = 9;
    const result = await getPropertyImages(propid); // Backend Integration
    if (result.status == 200) {
      const data = result.data;
      return data;
    } else {
      toast.warning('No Such Property Images Found');
      return null;
    }
  };

  const WishlistAdd = async (propId) => {
    // const id = 9;
    const userId=sessionStorage.getItem('userid')
    const result = await addPropertyWishlist(userId,propId); // Backend Integration
    console.log(result)
    if (result.status == 200) {
      toast.success("Property Added to Wishlist")
      navigate("/wishlist")
    } 
    else {
      toast.warning('Faced Some Issue:'+result.data.message);
    }
  };

  useEffect(() => {
    (async () => {
      const prop = await fetchData()
      const { title, address, propertyType, tags, price, propertyArea, bedrooms, bathrooms, description,owner } = prop
      setTitle(title);
      setAddressLine1(address.addLine1);
      setAddressLine2(address.addLine2);
      setCity(address.city);
      setState(address.state);
      setDistrict(address.district);
      setPincode(address.pincode);
      const tagsArray = tags.map(tag => tag.tagName); // Update the state asynchronously
      setSelectedTags(tagsArray);
      setType(propertyType);
      setPrice(price);
      setArea(propertyArea);
      setBedroom(bedrooms);
      setBathroom(bathrooms);
      setDescpt(description);
      setOwnerName(owner)
      images = await fetchImage()
      setImages(images)
      Images.map((image) => {
        return (`${config.url}` + `/${image.imageLink}`)
      })
    })();
  }, []);
  // - End Backend Integreation Code
  return (
    <div>
      <Header />
      <h1 className="centered mt-3">Individual Property</h1>
      <div className="container">
        <h2>
          Property Name: <b>{Title}</b>{" "}
        </h2>
        <div className="slider-container mb-3">
          <br />
          <h4>Sample Property Images:</h4>
          <Slider {...settings}>
            {Images.map((image) => {
             return(<div>
                <center>
                  <img src={"data:image/png;base64,"+`${image.imageData}`} alt={"Test Image"} className="CarouselImage" />
                </center>
              </div>)
            })}
          </Slider>
          <br />
        </div>
        <div class="container">
          <div class="row">
            <div class="col-6">
              <h2>Property Tags: <i>{selectedTags.map((tag) => tag + ",")}</i></h2>
              <hr />
              <br />
              <h2>
                <em>Property Short Description:</em>
              </h2>
              <p>{Descpt}</p>
              <hr />
              <br />
              <h2>
                <em>Property Specifications:</em>
              </h2>
              <p className="fs-5">
                <b>Type:</b>
                {Type}
              </p>
              <p className="fs-5">
                <b>Area:</b>
                {Area} sq.mt
              </p>
              <p className="fs-5">
                <b>Bedroom Count:</b>
                {Bedroom}
              </p>
              <p className="fs-5">
                <b>Bathroom Count:</b>
                {Bathroom}
              </p>
              <p className="fs-5">
                <b>Property Owner:</b>{OwnerName}
              </p>
              <br />
            </div>
            <div class="col-6">
              <h2>
                <em>Location</em>
              </h2>
              <p className="fs-5">
                <b>Address Line 1:</b>
                <em>{AddressLine1}</em>&nbsp;&nbsp;&nbsp;&nbsp;
                <b>Address Line 2:</b>
                <em>{AddressLine2}</em>&nbsp;&nbsp;&nbsp;&nbsp;

              </p>
              <p className="fs-5">
                <b>City:</b>
                <em>{City}</em>&nbsp;&nbsp;&nbsp;&nbsp;
                <b>District:</b>
                <em>{District}</em> &nbsp;&nbsp;&nbsp;&nbsp;<b>State:</b>
                {State}
              </p>
              <p className="fs-5">
                <b>Pincode:</b>
                {Pincode}
              </p>
              <br />
              <hr />
              <br />
              <p className="fs-5"><b>Price:&#8377;</b>{Price}&nbsp;&nbsp;&nbsp;&nbsp; <button className="btn btn-success ms-2"><a href="/checkout">Buy Now</a></button></p>
              <button className="btn btn-warning me-3" onClick={()=>{WishlistAdd(propid)}}>Add to Wishlist</button>
            </div>
          </div>
        </div>
      </div>
      <Footer />
    </div>
  );
}

export default IndividualProperties;


