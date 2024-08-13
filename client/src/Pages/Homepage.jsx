import { useEffect, useState } from "react";
import Footer from "../Components/Footer";
import Header from "../Components/Header";
import ProductCard from "../Components/ProductCard";
import ReviewCard from "../Components/ReviewCard";
import { GetAllProperty } from "../services/property";
import { toast } from "react-toastify";

function Homepage() {
  const [Properities, SetProperities] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const [totalPages, setTotalPages] = useState(4);
  const [loading, setLoading] = useState(false);

  const itemsPerPage = 3;
  const handlePageChange = (page) => {
    setCurrentPage(page);
  };
  const fetchData = async (page) => {
    setLoading(true);
    try {
      const result = await GetAllProperty(page, itemsPerPage); // Backend Integration
      if (result.status == 200) {
        const data = result.data;
        console.log(data.properties)
        setTotalPages(data.totalPages)
        return data.properties;
      } else {
        toast.warning('No Property Found');
        return null;
      }
    } catch (error) {
      console.error('Error fetching property data:', error);
      toast.error('Error fetching property data');
      return null;
    }
    finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    (async () => {
      const prop = await fetchData(currentPage);
      // console.log(prop)
      SetProperities([...prop])
    })();
  }, [currentPage]);
  const reviews = [
    {
      avatar: "https://via.placeholder.com/60",
      name: "John Doe",
      review: "This is an amazing product! Highly recommend it.",
      rating: 5,
    },
    {
      avatar: "https://via.placeholder.com/60",
      name: "Jane Smith",
      review: "Good quality but a bit expensive.",
      rating: 4,
    },
    // Add more reviews as needed
  ];

  return (
    <div>
      <Header />
      <div className="homepage">
        <div className="overlay">
          <div className="content">
            <h1>Find Your Dream Property</h1>
            <button className="cta-button">Get Started</button>
          </div>
        </div>
      </div>
      <div className="container">
        <h1 className="centered">Properties</h1>
        <div className="row">
          {Properities.map((property) => {
            return (
              <div className="col m-4">
                <ProductCard page={{ name: "homepage" }} id={property.id} title={property.title} description={property.description} price={property.price} owner={property.owner} />

              </div>
            );
          })}
        </div>
        <div className="pagination justify-content-center">
          <button
         class="page-link me-2 mb-2"
            onClick={() => handlePageChange(currentPage - 1)}
            disabled={currentPage === 1}
          >
            Previous
          </button>
          <span>Page {currentPage} of {totalPages}</span>
          <button
          class="page-link ms-2 mb-2"
            onClick={() => handlePageChange(currentPage + 1)}
            disabled={currentPage === totalPages}
          >
            Next
          </button>
        </div>
      </div>
      <Footer />
    </div>
  );
}

export default Homepage;
