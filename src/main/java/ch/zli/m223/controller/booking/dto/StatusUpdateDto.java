package ch.zli.m223.controller.booking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import ch.zli.m223.model.Booking;

public class StatusUpdateDto {
    @JsonProperty("bookingStatus")
    private Booking.BookingStatus status;

    public Booking.BookingStatus getStatus() {
        return status;
    }

    public void setStatus(Booking.BookingStatus status) {
        this.status = status;
    }
    
}
