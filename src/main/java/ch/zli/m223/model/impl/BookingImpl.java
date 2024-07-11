package ch.zli.m223.model.impl;

import ch.zli.m223.model.Booking;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "Booking")
public class BookingImpl implements Booking{
    
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, name = "user_id")
    private Long userId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "booking_date")
    private String bookingDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "duration")
    private Duration duration;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "booking_status")
    private BookingStatus bookingStatus;

    public BookingImpl() {}

    public BookingImpl(Long userId, String bookingDate, Duration duration, BookingStatus bookingStatus) {
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
    public Duration getDuration() {
        return duration;
    }

    @Override
    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    @Override
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    @Override
    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @Override
    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
