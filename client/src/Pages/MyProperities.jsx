import { toast } from "react-toastify";
import Footer from "../Components/Footer";
import Header from "../Components/Header";
import ProductCard from "../Components/ProductCard";
import { GetSpecficPropertyUser } from "../services/property";
import { useEffect, useState } from "react";

function MyProperities() {
  const [Properities, SetProperities] = useState([]);

  const fetchData = async () => {
    const id = 9;
    try {
      const result = await GetSpecficPropertyUser(id); // Backend Integration
      if (result.status == 200) {
        const data = result.data;
        return data;
      } else {
        toast.warning('No Property Found');
        return null;
      }
    } catch (error) {
      console.error('Error fetching property data:', error);
      toast.error('Error fetching property data');
      return null;
    }
  };

  useEffect(() => {
    (async () => {
      const prop = await fetchData()
      console.log(prop)
      SetProperities([...prop])
    })();
  }, []);
  return (
    <div>
      <Header />
      <h1 className="centered mt-3">My Properties</h1>
      <div className="container">
        <div className="d-grid gap-2 d-md-flex justify-content-md-end mb-3 me-5">
          <a href="/add-property" class="btn btn-success me-5">
            Add New Property
          </a>
        </div>
        <div className="row">
          {Properities.map((property) => {
            return (
              <div className="col m-4">
                <ProductCard page={{ name: "Edit-Prop" }} id={property.id} title={property.title} description={property.description} price={property.price} owner={property.owner} />
              </div>
            );
          })}
        </div>
      </div>
      <Footer />
    </div>
  );
}

export default MyProperities;
