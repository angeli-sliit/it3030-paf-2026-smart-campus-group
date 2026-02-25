import { Navigate } from 'react-router-dom'
import { useAuth } from '../context/AuthContext.jsx'

// Simple PrivateRoute wrapper. Logic will be refined later.
export function PrivateRoute({ children }) {
  const auth = useAuth()

  if (!auth.isAuthenticated) {
    return <Navigate to="/login" replace />
  }

  return children
}

