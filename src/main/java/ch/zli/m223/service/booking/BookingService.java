package ch.zli.m223.service.booking;

import java.security.Principal;
import java.util.List;

import ch.zli.m223.model.Booking;
import ch.zli.m223.model.impl.BookingImpl;

public interface BookingService {
    List<Booking> getAllBookings();
    Booking getBookingByBookingId(Long bookingId);
    Booking getBookingMemberByBookingId(Long id, Principal principal);
    List<BookingImpl> getBookingByDate(String date);
    List<BookingImpl> getMemberBookingsByUserId(Long userId, Principal principal);
    List<BookingImpl> getBookingsByUserId(Long userId);
    BookingImpl createBooking(Long userid, String bookingDate, Booking.Duration duration);
    public Booking createBookingWithStatus(Long userid, String bookingDate, Booking.Duration duration, Booking.BookingStatus status);
    public BookingImpl updateBookingStatus(Long id, Booking.BookingStatus status);
    void deleteBooking(Long id);
    void deleteMemberBooking(Long id, Principal principal);
}
