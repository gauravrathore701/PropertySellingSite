import { Link } from "react-router-dom";

function List() {
  return (
    <div>
      <h3>
        <Link to="/login">Login Page</Link> <br />
        <Link to="/contact-us">Contact Us Page</Link>
        <br />
        <Link to="/edit-property">Edit Property Page</Link>
        <br />
        <Link to="/add-property">Add Property Page</Link>
        <br />
        <Link to="/product-card">Product Card Page</Link>
        <br />
        <Link to="/wishlist">Wishlist Page</Link>
        <br />
      </h3>
    </div>
  );
}

export default List;
