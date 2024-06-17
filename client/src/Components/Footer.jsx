import { Link } from "react-router-dom";

function Footer() {
  return (
    <div className="footer container-fluid">
      <div className="row pt-1 pb-5 mx-4">
        <div className="col-md-5 col-sm-12 mt-2">
          <h5>Quick Links (For Developer Navigation(ForNow))</h5>
          <list>
            <li>
              <Link to="/login">Login Page</Link>
            </li>
            <li>
              <Link to="/contact-us">Contact Us Page</Link>
            </li>
            <li>
              <Link to="/edit-property">Edit Property Page</Link>
            </li>
            <li>
              <Link to="/add-property">Add Property Page</Link>
            </li>
          </list>
        </div>
        <div className="col-md-5 col-sm-12 mt-2">
          <h5>Something Else</h5>
          <p>
            Lorem ipsum, dolor sit amet consectetur adipisicing elit. Doloremque
            pariatur, repellat aperiam quod excepturi atque mollitia tempore
            alias, natus reprehenderit quaerat consequatur blanditiis rem
            temporibus laboriosam? Est blanditiis minima aliquid?
          </p>
        </div>
        <div className="col-md-2 col-sm-12 mt-2">
          <h5>Social Media</h5>
        </div>
      </div>
      <div className="row mx-4">
        <div className="col-10">
          &copy; 2024 Property Selling Site | <a href="#">Privacy</a> |{" "}
          <a href="#">Terms</a> | <a href="#">SiteMap</a> |{" "}
          <a href="#">Project Details</a>
        </div>
        <div className="col"></div>
      </div>
    </div>
  );
}

export default Footer;
