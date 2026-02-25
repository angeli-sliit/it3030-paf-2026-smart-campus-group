import axios from 'axios'

// Shared Axios instance for calling the Spring Boot backend.
// Member 4 will add interceptors for JWT and auth headers.
export const api = axios.create({
  // Default to localhost:8080 for Docker Compose and local dev.
  baseURL: 'http://localhost:8080/api/v1',
})

