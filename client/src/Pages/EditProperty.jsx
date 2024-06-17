import { useState } from "react"
import { toast } from "react-toastify"


function EditProperty() {
    const [title, setTitle] = useState("Test1")
    const [Descpt, setDescpt] = useState("Testing Description")
    const [Address, setAddress] = useState("Thivim")
    const [State, setState] = useState("Goa")
    const [District, setDistrict] = useState("Pune")
    const [City, setCity] = useState("Pune")
    const [Pincode, setPincode] = useState("403502")
    const [Type, setType] = useState("Apartment")
    const [Area, setArea] = useState("5000")
    const [Bedroom, setBedroom] = useState("5")
    const [Bathroom, setBathroom] = useState("8")
    const [Price, setPrice] = useState("4500000")

    const editProp = async () => {
        if (title.length === 0) {
            toast.warning("Please Enter Property Title")
        }
        else if (Descpt.length === 0) {
            toast.warning("Please Enter Property Description")
        } else if (Address.length === 0) {
            toast.warning("Please Enter Property Address")
        }else if (Descpt.length === 0) {
            toast.warning("Please Enter Property Description")
        } else if (State.length === 0) {
            toast.warning("Please Enter Property State")
        }else if (District.length === 0) {
            toast.warning("Please Enter Property District")
        } else if (City.length === 0) {
            toast.warning("Please Enter Property City")
        }else if (Pincode.length === 0) {
            toast.warning("Please Enter Property Pincode")
        } else if (Area.length === 0) {
            toast.warning("Please Enter Property Area")
        } else if (Type.length === 0) {
            toast.warning("Please Enter Property Type")
        } else if (Bedroom.length === 0) {
            toast.warning("Please Enter Property Bedrooms")
        } else if (Bathroom.length === 0) {
            toast.warning("Please Enter Property Bathrooms")
        } else if (Price.length === 0) {
            toast.warning("Please Enter Property Price")
        }
        else {
            toast.success("Data Added Successfully")
        }
    }
    return (
        <div className="row">

            <div className="col md-4"></div>

            <div className="container contactUsForm col-lg-6 col-md-12 px-4 mt-3 ">
                {/* <form action="" method="post"> */}
                    <h1 className="centered mb-5 mt-5">Edit Property</h1>
                    <div className="form-label">Property Title: </div>
                    <div><input type="text" placeholder="Property Title" name="PropName" value={title} onChange={(e) => { setTitle(e.target.value) }} className="form-control mb-5" /></div>
                    <div className="form-label ">Property Description:</div>
                    <textarea type="text" placeholder="Property Description" name="PropDescript" value={Descpt}onChange={(e) => { setDescpt(e.target.value) }}  className="form-control" rows={5} />
                    <div className="form-label mt-5">Address: </div>
                    <div><textarea type="text" placeholder="Enter Address" name="Address" value={Address} onChange={(e) => { setAddress(e.target.value) }} className="form-control mb-3" /></div>
                    <div class="container mt-5">
                        <div class="row mt-5">
                            <div class="col me-5">
                                <div className="form-label">Property State: </div>
                                <select class="form-select" name="State" aria-label="Select State" value={State} onChange={(e) => { setState(e.target.value) }}>
                                    <option value="Maharastra">Maharastra</option>
                                    <option selected value="Goa">Goa</option>
                                    <option value="Karnataka">Karnataka</option>
                                </select>
                            </div>
                            <div class="col me-3">
                                <div className="form-label">Property District: </div>
                                <select class="form-select" name="District" value={District} aria-label="Select District" onChange={(e) => { setDistrict(e.target.value) }}>
                                    <option value="Pune">Pune</option>
                                    <option selected value="North-Goa">North-Goa</option>
                                    <option value="Belgaum">Belgaum</option>
                                </select>
                            </div>
                        </div>
                        <div class="row mt-5">
                            <div class="col me-5">
                                <div className="form-label">Property City: </div>
                                <input type="text" placeholder="Select City" value={City} name="City"  onChange={(e) => { setCity(e.target.value) }} className="form-control" />
                            </div>
                            <div class="col me-3">
                                <div className="form-label">Property Pincode: </div>
                                <input type="number" placeholder="Enter Pincode" value={Pincode} name="Pincode"  onChange={(e) => { setPincode(e.target.value) }}  className="form-control" />
                            </div>
                        </div>
                        <div class="row mt-5">
                            <div class="col me-5">
                                <div className="form-label">Property Type: </div>
                                <select class="form-select" name="PropType" value={Type} aria-label="Select Type" onChange={(e) => { setType(e.target.value) }}>
                                    <option value="Bunglow">Bunglow</option>
                                    <option selected value="Apartment">Apartment</option>
                                    <option value="Villa">Villa</option>
                                </select>
                            </div>
                            <div class="col me-3">
                                <div className="form-label">Property Area: </div>
                                <input type="number" placeholder="Enter Area" value={Area} name="Area" onChange={(e) => { setArea(e.target.value) }} className="form-control mb-5" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col me-5">
                                <div className="form-label">Property Bedrooms: </div>
                                <input type="number" placeholder="Enter Number of Bedrooms" value={Bedroom} name="Bedroom"  onChange={(e) => { setBedroom(e.target.value) }} className="form-control mb-5" />
                            </div>
                            <div class="col me-3">
                                <div className="form-label">Property Bathrooms: </div>
                                <input type="number" placeholder="Enter Number of Bathrooms" value={Bathroom} name="Bathroom" onChange={(e) => { setBathroom(e.target.value) }}className="form-control mb-5" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col me-5">
                                <div className="form-label">Property Price: </div>
                                <input type="number" placeholder="Enter Price" name="Price" value={Price} onChange={(e) => { setPrice(e.target.value) }}className="form-control mb-5" />
                            </div>
                            <div class="col me-3">
                                <div className="form-label">Property Images: </div>
                                <input class="form-control" type="file" name="Images" id="formFileMultiple" multiple />
                            </div>
                        </div>
                        <div className="row justify-content-center mb-3">
                            <input type="Submit" className="btn btn-success col-2" onClick={editProp} placeholder="Add Property" />
                        </div>
                    </div>
                {/* </form> */}
            </div >
            <div className="col md-4"></div>
        </div >
    )
}

export default EditProperty;