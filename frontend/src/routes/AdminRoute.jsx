import { Navigate } from 'react-router-dom'
import { useAuth } from '../context/AuthContext.jsx'

// Admin-only route guard. Member 4 will refine role logic.
export function AdminRoute({ children }) {
  const auth = useAuth()

  if (!auth.isAuthenticated) {
    return <Navigate to="/login" replace />
  }

  if (!auth.hasRole('ADMIN')) {
    return <Navigate to="/not-authorized" replace />
  }

  return children
}

