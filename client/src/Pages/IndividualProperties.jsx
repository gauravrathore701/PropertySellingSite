import Footer from "../Components/Footer";
import Header from "../Components/Header";
import PropertyCard from "../Components/PropertyCard";

function IndividualProperties() {
  const arr = [1, 2, 3,4];

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
          {arr.map((element) => {
            return (
              <div className="col m-4">
                <PropertyCard page={{ name: "Edit-Prop" }} />
              </div>
            );
          })}
        </div>
      </div>
      <Footer />
    </div>
  );
}

export default IndividualProperties;
