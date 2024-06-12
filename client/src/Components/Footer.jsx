function Footer(){

    return(
        <div className="footer container-fluid">
            <div className="row pt-1 pb-5 mx-4">
                <div className="col-5">
                    <h5>Quick Links</h5>
                    <list>
                        <li>Homepage</li>
                        <li>Contact Us</li>

                    </list>
                </div>
                <div className="col-5">
                    <h5>Something Else</h5>
                    <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Doloremque pariatur, repellat aperiam quod excepturi atque mollitia tempore alias, natus reprehenderit quaerat consequatur blanditiis rem temporibus laboriosam? Est blanditiis minima aliquid?</p>
                </div>
                <div className="col">
                    <h5>Social Media</h5>
                </div>
            </div>
            <div className="row mx-4">
                <div className="col-10">&copy; 2024 Property Selling Site | <a href="#">Privacy</a> | <a href="#">Terms</a> | <a href="#">SiteMap</a> | <a href="#">Project Details</a></div>
                <div className="col"></div>
            </div>
        </div>
    )

}

export default Footer;