import axios from 'axios';

// Shared Axios instance for calling the Spring Boot backend.
const api = axios.create({
  baseURL: 'http://localhost:8080/api',
  withCredentials: true,
});

export default api;

