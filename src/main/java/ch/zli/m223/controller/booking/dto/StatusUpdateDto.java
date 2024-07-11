package ch.zli.m223.controller.booking.dto;

import ch.zli.m223.model.Booking;

public class StatusUpdateDto {
    private Booking.BookingStatus status;

    public Booking.BookingStatus getStatus() {
        return status;
    }

    public void setStatus(Booking.BookingStatus status) {
        this.status = status;
    }
    
}
