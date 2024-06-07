import { useState } from "react";


function LoginPage() {
//   // create state members
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

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
    <div className="container">
      <center>
        <h2 className="page-title mt-4">Login here</h2>
      </center>
      <div className="row mt-4">
        <div className="col-3"></div>

        <div className="col">
          <div className="form">
            <div className="mb-3">
              <label htmlFor="">Email</label>
              <input
                onChange={(e) => {
                  setEmail(e.target.value);
                }}
                type="email"
                className="form-control"
              />
            </div>
            <div className="mb-3">
              <label htmlFor="">Password</label>
              <input
                onChange={(e) => {
                  setPassword(e.target.value);
                }}
                type="password"
                className="form-control"
              />
            </div>
            <div className="mb-3">
              <div>
                Dont have an account yet?{" "}
                {/* <Link to='/register'>Register here</Link> */}
              </div>
              <button className="mt-2 btn btn-success">Login</button>
            </div>
          </div>
        </div>

        <div className="col-3"></div>
      </div>
    </div>
  );
}

export default LoginPage;
