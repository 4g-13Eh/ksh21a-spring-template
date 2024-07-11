package ch.zli.m223.service.booking.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zli.m223.model.Booking;
import ch.zli.m223.model.impl.BookingImpl;
import ch.zli.m223.repository.BookingRepository;
import ch.zli.m223.service.booking.BookingService;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> getAllBookings() {
        return new ArrayList<Booking>(bookingRepository.findAll());
    }

    @Override
    public Booking getBookingByBookingId(Long id){
        return bookingRepository.findById(id).orElseThrow(()-> new RuntimeException("Booking not found"));
    }

    @Override
    public List<BookingImpl> getBookingByDate(String date){
        return bookingRepository.findByBookingDate(date);
    }

    @Override
    public BookingImpl createBooking(Long userid, String bookingDate, Booking.Duration duration){
        BookingImpl booking = new BookingImpl();
        booking.setUserId(userid);
        booking.setBookingDate(bookingDate);
        booking.setDuration(duration);
        booking.setBookingStatus(Booking.BookingStatus.PENDING);
        return bookingRepository.save(booking);
    }

    @Override
    public Booking createBookingWithStatus(Long userid, String bookingDate, Booking.Duration duration, Booking.BookingStatus status){
        BookingImpl booking = new BookingImpl();
        booking.setUserId(userid);
        booking.setBookingDate(bookingDate);
        booking.setDuration(duration);
        booking.setBookingStatus(status);
        return bookingRepository.save(booking);
    }

    @Override
    public BookingImpl updateBookingStatus(Long id, Booking.BookingStatus status){
        BookingImpl booking = bookingRepository.findById(id).orElseThrow(()-> new RuntimeException("Booking not found"));
        booking.setBookingStatus(status);
        return bookingRepository.save(booking);
    }

    @Override
    public void deleteBooking(Long id){
        bookingRepository.deleteById(id);
    }
    
}
