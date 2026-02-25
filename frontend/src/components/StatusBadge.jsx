/**
 * StatusBadge component — displays a styled badge for status values.
 * Used across bookings, tickets, and resources.
 */
function StatusBadge({ status }) {
  const colorMap = {
    // Booking statuses
    PENDING: { bg: '#fef3c7', color: '#92400e' },
    APPROVED: { bg: '#d1fae5', color: '#065f46' },
    REJECTED: { bg: '#fee2e2', color: '#991b1b' },
    CANCELLED: { bg: '#e5e7eb', color: '#374151' },
    EXPIRED: { bg: '#f3f4f6', color: '#6b7280' },
    // Ticket statuses
    OPEN: { bg: '#dbeafe', color: '#1e40af' },
    IN_PROGRESS: { bg: '#fef3c7', color: '#92400e' },
    RESOLVED: { bg: '#d1fae5', color: '#065f46' },
    CLOSED: { bg: '#e5e7eb', color: '#374151' },
    // Resource statuses
    ACTIVE: { bg: '#d1fae5', color: '#065f46' },
    OUT_OF_SERVICE: { bg: '#fee2e2', color: '#991b1b' },
  }

  const style = colorMap[status] || { bg: '#f3f4f6', color: '#374151' }

  return (
    <span style={{
      display: 'inline-block',
      padding: '0.25rem 0.75rem',
      borderRadius: '9999px',
      fontSize: '0.75rem',
      fontWeight: 600,
      backgroundColor: style.bg,
      color: style.color,
      textTransform: 'uppercase'
    }}>
      {status}
    </span>
  )
}

export default StatusBadge
