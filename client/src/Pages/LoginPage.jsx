import { useState } from "react";
import { TbEye } from "react-icons/tb";
import { GoEyeClosed } from "react-icons/go";
import Footer from "../Components/Footer";
import { Link } from "react-router-dom";

function LoginPage() {
  //   // create state members
  // const [email, setEmail] = useState("");
  const [showPassword, setShowPassword] = useState("");
  const [data, setData] = useState({
    email: "",
    password: "",
  });

  const handleOnChange = (e) => {
    const { name, value } = e.target;

    setData((prev) => {
      return {
        ...prev,
        [name]: value,
      };
    });
  };

  // get the navigate object
  // const navigate = useNavigate()

  //   const onLogin = async () => {
  //     // client side validation
  //     if (email.length === 0) {
  //       toast.warning('enter email')
  //     } else if (password.length === 0) {
  //       toast.warning('enter password')
  //     } else {
  //       const result = await login(email, password)
  //       if (result['status'] === 'success') {
  //         // read the token
  //         // const token = result['data']['token']
  //         // const name = result['data']['name']
  //         const { token, name } = result['data']

  //         // set the data in session storage
  //         // sessionStorage.token = token
  //         // sessionStorage.name = name

  //         // sessionStorage['token'] = token
  //         // sessionStorage['name'] = name

  //         sessionStorage.setItem('token', token)
  //         sessionStorage.setItem('name', name)

  //         toast.success('welcome to the application')
  //         navigate('/home')
  //       } else {
  //         toast.error('invalid email or password')
  //       }
  //     }
  //   }

  return (
    <div>
      <div className="container loginformContainer loginForm col-lg-6  mb-1 px-7 py-4">
        <h2 className="centered tw-h mb-4 mt-6">Login here</h2>
        <div className="form-label">Email</div>
        <input
          onChange={handleOnChange}
          type="email"
          name="email"
          value={data.email}
          placeholder="Enter Your Email"
          className="form-control"
        />

        <div className="form-label">Password</div>
        <div className="d-flex align-items-center position-relative">
          <input
            type={showPassword ? "text" : "password"}
            placeholder="Enter Your Password"
            name="password"
            value={data.password}
            onChange={handleOnChange}
            className="form-control"
          />
          <div
            onClick={() => setShowPassword((prev) => !prev)}
            className="position-absolute end-0 me-2"
            style={{ cursor: "pointer" }}
          >
            <span style={{ fontSize: "1.7rem" }}>
              {showPassword ? <TbEye /> : <GoEyeClosed />}
            </span>
          </div>
        </div>

        <div>
          <p className="my-5">
            Don't have account ?{" "}
            <Link
              to={"/login"}
              className="tw-text-blue-500 hover:tw-text-red-800 tw-underline"
            >
              Sign Up
            </Link>
          </p>
        </div>
        <button className="mt-2 btn btn-success">Login</button>
      </div>
      <div style={{ position: "absolute", bottom: "0" }}>
        <Footer />
      </div>
    </div>
  );
}

export default LoginPage;
