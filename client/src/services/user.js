import axios from "axios";
import config from "../config";

export async function GetAllUsers() {
  // Make API Call
  const response = await axios.get(`${config.url}/Users/list`);
  // Reading JSON data
  return response;
}
export async function EditSpecficUserId(body,userId) {
  // make API call
  const response = await axios.put(`${config.url}/Users/update/${userId}`, body);
  // read JSON data (response)
  return response.data;
}

export async function addUser(body) {
  // make API call
  const response = await axios.post(`${config.url}/Users/add/`, body);
  // read JSON data (response)
  return response;
}

export async function userLogin(body) {
  // make API call
  const response = await axios.post(`${config.url}/Users/login`, body);
  // read JSON data (response)
  return response;
}

