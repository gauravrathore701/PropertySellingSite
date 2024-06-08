function AddProperty() {
    return (
        <div className="row">

            <div className="col md-4"></div>

            <div className="container contactUsForm col-lg-6 col-md-12 px-4 mt-3 ">
                <form action="" method="post">
                    <h1 className="centered mb-5 mt-5">Add Property</h1>
                    <div className="form-label">Property Title: </div>
                    <div><input type="text" placeholder="Property Title" className="form-control mb-5" /></div>
                    <div className="form-label ">Property Description:</div>
                    <textarea type="text" placeholder="Property Description" className="form-control" rows={5} />
                    <div className="form-label mt-5">Address: </div>
                    <div><textarea type="text" placeholder="Enter Address" className="form-control mb-3" /></div>
                    <div class="container mt-5">
                        <div class="row mt-5">
                            <div class="col me-5">
                                <div className="form-label">Property State: </div>
                                <select class="form-select" aria-label="Select State">
                                    <option selected>Select State</option>
                                    <option value="Maharastra">Maharastra</option>
                                    <option value="Goa">Goa</option>
                                    <option value="Karnataka">Karnataka</option>
                                </select>
                            </div>
                            <div class="col me-3">
                                <div className="form-label">Property City: </div>
                                <select class="form-select" aria-label="Select District">
                                    <option selected>Select District</option>
                                    <option value="Pune">Pune</option>
                                    <option value="North-Goa">North-Goa</option>
                                    <option value="Belgaum">Belgaum</option>
                                </select>
                            </div>
                        </div>
                        <div class="row mt-5">
                            <div class="col me-5">
                                <div className="form-label">Property City: </div>
                                <input type="text" placeholder="Select City" className="form-control" />
                            </div>
                            <div class="col me-3">
                                <div className="form-label">Property Pincode: </div>
                                <input type="text" placeholder="Enter Pincode" className="form-control" />
                            </div>
                        </div>
                        <div class="row mt-5">
                            <div class="col me-5">
                                <div className="form-label">Property Type: </div>
                                <select class="form-select" aria-label="Select Type">
                                    <option selected>Select Type</option>
                                    <option value="Bunglow">Bunglow</option>
                                    <option value="Apartment">Apartment</option>
                                    <option value="Villa">Villa</option>
                                </select>
                            </div>
                            <div class="col me-3">
                                <div className="form-label">Property Area: </div>
                                <input type="text" placeholder="Enter Area" className="form-control mb-5" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col me-5">
                                <div className="form-label">Property Bedrooms: </div>
                                <input type="text" placeholder="Enter Number of Bedrooms" className="form-control mb-5" />
                            </div>
                            <div class="col me-3">
                                <div className="form-label">Property Bathrooms: </div>
                                <input type="text" placeholder="Enter Number of Bathrooms" className="form-control mb-5" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col me-5">
                                <div className="form-label">Property Price: </div>
                                <input type="text" placeholder="Enter Price" className="form-control mb-5" />
                            </div>
                            <div class="col me-3">
                                <div className="form-label">Property Images: </div>
                                <input class="form-control" type="file" id="formFileMultiple" multiple />
                            </div>
                        </div>
                        <div className="row justify-content-center mb-3">
                            <input type="Submit" className="btn btn-success col-2" placeholder="Add Property" />
                        </div>

                    </div>

                </form>
            </div >

            <div className="col md-4"></div>
        </div >
    )
}

export default AddProperty;