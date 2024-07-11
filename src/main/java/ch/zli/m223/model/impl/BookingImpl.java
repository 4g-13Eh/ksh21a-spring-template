package ch.zli.m223.model.impl;

import ch.zli.m223.model.Booking;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "Booking")
public class BookingImpl implements Booking{
    
    @Id
    @GeneratedValue
    private Long id;

    @ForeignKey
    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String bookingDate;

    @ForeignKey
    @Column(nullable = false)
    private Long duration;

    @ForeignKey
    @Column(nullable = false)
    private Long bookingStatus;


    public BookingImpl(Long userId, String bookingDate, Long duration, Long bookingStatus) {
        this.userId = userId;
        this.bookingDate = bookingDate;
        this.duration = duration;
        this.bookingStatus = bookingStatus;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Long getUserId() {
        return userId;
    }

    @Override
    public String getBookingDate() {
        return bookingDate;
    }

    @Override
    public Long getDuration() {
        return duration;
    }

    @Override
    public Long getBookingStatus() {
        return bookingStatus;
    }

}
