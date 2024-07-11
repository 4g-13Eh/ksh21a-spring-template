package ch.zli.m223.service.booking;

import java.util.List;

import ch.zli.m223.model.Booking;
import ch.zli.m223.model.impl.BookingImpl;

public interface BookingService {
    List<Booking> getAllBookings();
    Booking getBookingByBookingId(Long id);
    List<BookingImpl> getBookingByDate(String date);
    BookingImpl createBooking(Long userid, String bookingDate, Booking.Duration duration);
    public Booking createBookingWithStatus(Long userid, String bookingDate, Booking.Duration duration, Booking.BookingStatus status);
    public BookingImpl updateBookingStatus(Long id, Booking.BookingStatus status);
    void deleteBooking(Long id);
}
