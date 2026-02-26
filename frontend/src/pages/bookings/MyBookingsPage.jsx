import React, { useEffect, useState } from "react";
import api from "../../services/api";
import StatusBadge from "../../components/StatusBadge";

const MyBookingsPage = () => {
  const [bookings, setBookings] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  const fetchBookings = async () => {
    setLoading(true);
    try {
      const res = await api.get("/bookings/my");
      setBookings(res.data);
    } catch {
      setError("Failed to load bookings");
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchBookings();
  }, []);

  return (
    <div>
      <h2>My Bookings</h2>
      {loading ? (
        <div>Loading...</div>
      ) : error ? (
        <div style={{color:'red'}}>{error}</div>
      ) : (
        <table>
          <thead>
            <tr>
              <th>Resource</th>
              <th>Start</th>
              <th>End</th>
              <th>Status</th>
              <th>Purpose</th>
              <th>Attendees</th>
            </tr>
          </thead>
          <tbody>
            {bookings.map((b) => (
              <tr key={b.id}>
                <td>{b.resourceId}</td>
                <td>{new Date(b.startTime).toLocaleString()}</td>
                <td>{new Date(b.endTime).toLocaleString()}</td>
                <td><StatusBadge status={b.status} /></td>
                <td>{b.purpose}</td>
                <td>{b.attendees}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};

export default MyBookingsPage;
