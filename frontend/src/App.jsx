import { BrowserRouter, Routes, Route } from 'react-router-dom'
import './App.css'
import { AuthProvider } from './context/AuthContext.jsx'
import LoginPage from './pages/auth/LoginPage.jsx'
import ResourcesPage from './pages/resources/ResourcesPage.jsx'
import BookingsPage from './pages/bookings/BookingsPage.jsx'
import TicketsPage from './pages/tickets/TicketsPage.jsx'
import AdminDashboardPage from './pages/admin/AdminDashboardPage.jsx'
import { PrivateRoute } from './routes/PrivateRoute.jsx'
import { AdminRoute } from './routes/AdminRoute.jsx'

function App() {
  return (
    <AuthProvider>
      <BrowserRouter>
        <Routes>
          <Route path="/login" element={<LoginPage />} />

          <Route
            path="/resources"
            element={
              <PrivateRoute>
                <ResourcesPage />
              </PrivateRoute>
            }
          />

          <Route
            path="/bookings"
            element={
              <PrivateRoute>
                <BookingsPage />
              </PrivateRoute>
            }
          />

          <Route
            path="/tickets"
            element={
              <PrivateRoute>
                <TicketsPage />
              </PrivateRoute>
            }
          />

          <Route
            path="/admin"
            element={
              <AdminRoute>
                <AdminDashboardPage />
              </AdminRoute>
            }
          />
        </Routes>
      </BrowserRouter>
    </AuthProvider>
  )
}

export default App
