import React from "react";
import BookingForm from "./BookingForm";
import MyBookingsPage from "./MyBookingsPage";

const BookingsPage = () => (
  <div>
    <BookingForm onSuccess={() => window.location.reload()} />
    <hr />
    <MyBookingsPage />
  </div>
);

export default BookingsPage;

