import { BrowserRouter, Routes, Route, Navigate, useLocation } from 'react-router-dom';
import './App.css';
import { AuthProvider } from './context/AuthContext.jsx';
import Navbar from './components/Navbar.jsx';
import LoginPage from './pages/auth/LoginPage.jsx';
import ResourcesPage from './pages/resources/ResourcesPage.jsx';
import BookingsPage from './pages/bookings/BookingsPage.jsx';
import TicketsPage from './pages/tickets/TicketsPage.jsx';
import NotificationsPage from './pages/notifications/NotificationsPage.jsx';
import AdminDashboardPage from './pages/admin/AdminDashboardPage.jsx';
import PrivateRoute from './routes/PrivateRoute.jsx';
import { AdminRoute } from './routes/AdminRoute.jsx';

function AppRoutes() {
  const location = useLocation();
  const hideNavbar = location.pathname === '/login';

  return (
    <>
      {!hideNavbar && <Navbar />}
      <Routes>
        <Route path="/" element={<Navigate to="/login" replace />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/resources" element={<PrivateRoute><ResourcesPage /></PrivateRoute>} />
        <Route path="/bookings" element={<PrivateRoute><BookingsPage /></PrivateRoute>} />
        <Route path="/tickets" element={<PrivateRoute><TicketsPage /></PrivateRoute>} />
        <Route path="/notifications" element={<PrivateRoute><NotificationsPage /></PrivateRoute>} />
        <Route path="/admin" element={<AdminRoute><AdminDashboardPage /></AdminRoute>} />
        <Route path="*" element={<Navigate to="/login" replace />} />
      </Routes>
    </>
  );
}

function App() {
  return (
    <BrowserRouter>
      <AuthProvider>
        <AppRoutes />
      </AuthProvider>
    </BrowserRouter>
  );
}

export default App;