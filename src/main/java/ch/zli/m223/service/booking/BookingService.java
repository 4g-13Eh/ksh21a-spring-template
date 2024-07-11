package ch.zli.m223.service.booking;

import java.util.List;

import ch.zli.m223.model.Booking;
import ch.zli.m223.model.impl.BookingImpl;

public interface BookingService {
    List<Booking> getAllBookings();
    Booking getBookingByBookingId(Long id);
    BookingImpl createBooking(BookingImpl booking);
    BookingImpl updateBooking(BookingImpl booking);
    void deleteBooking(Long id);
}
