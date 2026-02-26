import React, { useState } from "react";
import api from "../../services/api";

const BookingForm = ({ onSuccess }) => {
  const [form, setForm] = useState({
    resourceId: "",
    startTime: "",
    endTime: "",
    purpose: "",
    attendees: 1,
  });
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    setError("");
    try {
      await api.post("/bookings", form);
      setForm({ resourceId: "", startTime: "", endTime: "", purpose: "", attendees: 1 });
      if (onSuccess) onSuccess();
    } catch (err) {
      setError(err.response?.data?.message || "Booking failed");
    } finally {
      setLoading(false);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>New Booking</h2>
      <input name="resourceId" value={form.resourceId} onChange={handleChange} placeholder="Resource ID" required />
      <input name="startTime" type="datetime-local" value={form.startTime} onChange={handleChange} required />
      <input name="endTime" type="datetime-local" value={form.endTime} onChange={handleChange} required />
      <input name="purpose" value={form.purpose} onChange={handleChange} placeholder="Purpose" required />
      <input name="attendees" type="number" min={1} value={form.attendees} onChange={handleChange} required />
      <button type="submit" disabled={loading}>{loading ? "Booking..." : "Book"}</button>
      {error && <div style={{color:'red'}}>{error}</div>}
    </form>
  );
};

export default BookingForm;
