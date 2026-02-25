import { createContext, useContext, useState } from 'react'

// Basic auth context skeleton. Member 4 will implement full logic.
const AuthContext = createContext(null)

export function AuthProvider({ children }) {
  const [authState, setAuthState] = useState({
    isAuthenticated: false,
    user: null,
    token: null,
  })

  const value = {
    ...authState,
    // Placeholder methods – to be implemented later
    login: () => {},
    logout: () => {},
    hasRole: () => false,
  }

  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>
}

export function useAuth() {
  return useContext(AuthContext)
}

