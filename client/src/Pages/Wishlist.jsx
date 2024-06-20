import Footer from "../Components/Footer";
import ProductCard from "../Components/ProductCard";

function WishlistPage() {
  const arr = [1, 2, 3, 4, 5, 6];

  return (
    <div>
      <h1 className="centered">WishList Page</h1>
      <div className="container">
        <div className="row">
          {arr.map((element) => {
            return (
              <div className="col m-2">
                <ProductCard page={{ name: "wishlist" }} />
              </div>
            );
          })}
        </div>
      </div>
      <Footer />
    </div>
  );
}

export default WishlistPage;
