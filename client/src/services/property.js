import axios from "axios";
import config from "../config";

export async function GetAllProperty(page, itemsPerPage) {
  // Make API Call
  try {
    const response = await axios.get(`${config.url}/Property/list`, {
      params: {
        page: page - 1,
        size: itemsPerPage,
      },
    });
    // Reading JSON data
    return response;
  } catch (error) {
    console.log(error.response.data.message)
    return error.response
  }
}

export async function GetSpecficProperty(title) {
  // body parameters
  const body = {
    title,
  };
  // make API call
  try {
    const response = await axios.post(`${config.url}/Property/search`, body);
    // read JSON data (response)
    return response.data;
  } catch (error) {
    console.log(error.response.data.message)
    return error.response
  }
}

export async function GetSpecficPropertyUser(userID) {
  // body parameters
  // make API call
  try {
    const response = await axios.get(`${config.url}/Property/user/${userID}`);
    // read JSON data (response)
    return response;
  } catch (error) {
    console.log(error.response.data.message)
    return error.response
  }
}

export async function GetSpecficPropertyId(propertyID) {
  // make API call
  try {
    const response = await axios.get(`${config.url}/Property/${propertyID}`);
    // read JSON data (response)
    return response;
  } catch (error) {
    console.log(error.response.data.message)
    return error.response
  }
}

export async function EditSpecficPropertyId(body, PropId) {
  // make API call
  try {
    const response = await axios.put(`${config.url}/Property/update/${PropId}`, body);
    // read JSON data (response)
    return response.data;
  } catch (error) {
    console.log(error.response.data.message)
    return error.response
  }
}

export async function addProperty(body, userID) {
  // make API call
  try {
    const response = await axios.post(`${config.url}/Property/add/${userID}`, body);
    // read JSON data (response)
    return response;
  } catch (error) {
    console.log(error.response.data.message)
    return error.response
  }
}

export async function addPropertyImages(Images, propertyID) {
  // body parameters
  var data = new FormData();
  Images.map((image) => {
    data.append("imageLink", image, image.name);
  })
  // make API call
  console.log("Image Data Sent:" + data)
  try {
    const response = await axios.post(`${config.url}/Image/add/${propertyID}`, data);

    // read JSON data (response)
    return response;
  } catch (error) {
    console.log(error.response.data.message)
    return error.response
  }
}

export async function DeleteProperty(propertyID) {
  // body parameters
  const body = {
    propertyID,
  };
  // make API call
  try {
    const response = await axios.delete(`${config.url}/property/${propertyID}`, {
      data: body,
    });
    // read JSON data (response)
    return response.data;
  } catch (error) {
    console.log(error.response.data.message)
    return error.response
  }
}


//------------Image Related-----

export async function getPropertyImages(propertyID) {
  // make API call
  try {
    const response = await axios.get(`${config.url}/Image/list/${propertyID}`);
    // /list/{propertyId}

    // read JSON data (response)
    return response;
  } catch (error) {
    console.log(error.response.data.message)
    return error.response
  }
}

export async function DeletePropertyImage(imageId) {
  // body parameters
  // make API call
  try {
    const response = await axios.delete(`${config.url}/Image/${imageId}`);
    // read JSON data (response)
    return response;
  } catch (error) {
    console.log(error.response.data.message)
    return error.response
  }
}

//----Tags Related---

export async function GetAllTags() {
  // Make API Call
  try {
    const response = await axios.get(`${config.url}/Tags/list`);
    // Reading JSON data
    return response;
  } catch (error) {
    console.log(error.response.data.message)
    return error.response
  }
}

//----------WishList Related----------------------
export async function GetAllUserWishlist(userID) {
  // Make API Call
  try {
    const response = await axios.get(`${config.url}/wishlist/list/wishlist/${userID}`);
    // Reading JSON data
    return response;
  } catch (error) {
    console.log(error.response.data.message)
    return error.response
  }
}

export async function addPropertyWishlist(userID, propertyID) {
  // body parameters
  const body =
  {
    userid: parseInt(userID),
    propertyid: parseInt(propertyID)
  }
  // make API call
  try {
    const response = await axios.post(`${config.url}/wishlist/add/wishlist`, body);
    return response;
  } catch (error) {
    console.log(error.response.data.message)
    return error.response
  }
  // read JSON data (response)
}