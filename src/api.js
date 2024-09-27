import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080/api', // Adjust the base URL as needed
});

export const addCollege = (college) => api.post('/addcollage', college);
export const getAllColleges = () => api.get('/getallcollage');
