package ch.zli.m223.controller.booking.dto;

import ch.zli.m223.model.Booking;

public class AdminBookingDto {
    private String bookingDate;
    private Booking.Duration duration;
    private Booking.BookingStatus status;

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Booking.Duration getDuration() {
        return duration;
    }

    public void setDuration(Booking.Duration duration) {
        this.duration = duration;
    }

    public Booking.BookingStatus getStatus() {
        return status;
    }

    public void setStatus(Booking.BookingStatus status) {
        this.status = status;
    }
    
}
