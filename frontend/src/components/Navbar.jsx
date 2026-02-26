import useAuth from '../context/useAuth';

/**
 * Navbar component — displayed on all authenticated pages.
 * Shows navigation links, user info, and notification bell.
 * All members will contribute to this component.
 */
function Navbar() {
  const auth = useAuth()

  return (
    <nav style={{
      display: 'flex',
      justifyContent: 'space-between',
      alignItems: 'center',
      padding: '1rem 2rem',
      backgroundColor: '#1e293b',
      color: '#f1f5f9',
      borderBottom: '2px solid #334155'
    }}>
      <div style={{ fontWeight: 700, fontSize: '1.25rem' }}>
        Smart Campus Hub
      </div>

      <div style={{ display: 'flex', gap: '1.5rem', alignItems: 'center' }}>
        <a href="/resources" style={{ color: '#94a3b8', textDecoration: 'none' }}>Resources</a>
        <a href="/bookings" style={{ color: '#94a3b8', textDecoration: 'none' }}>Bookings</a>
        <a href="/tickets" style={{ color: '#94a3b8', textDecoration: 'none' }}>Tickets</a>
        <a href="/notifications" style={{ color: '#94a3b8', textDecoration: 'none' }}>
          Notifications
        </a>
        {auth.hasRole('ADMIN') && (
          <a href="/admin" style={{ color: '#facc15', textDecoration: 'none' }}>Admin</a>
        )}
      </div>

      <div style={{ display: 'flex', gap: '1rem', alignItems: 'center' }}>
        {auth.isAuthenticated ? (
          <>
            <span style={{ fontSize: '0.875rem', color: '#94a3b8' }}>
              {auth.user?.name || 'User'}
            </span>
            <button
              onClick={auth.logout}
              style={{
                background: '#ef4444',
                color: 'white',
                border: 'none',
                borderRadius: '6px',
                padding: '0.4rem 1rem',
                cursor: 'pointer'
              }}
            >
              Logout
            </button>
          </>
        ) : (
          <a href="/login" style={{ color: '#60a5fa', textDecoration: 'none' }}>Login</a>
        )}
      </div>
    </nav>
  )
}

export default Navbar
