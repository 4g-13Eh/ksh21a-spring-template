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

    @Override
    public List<Booking> getAllBookings() {
        return new ArrayList<Booking>(bookingRepository.findAll());
    }

    @Override
    public Booking getBookingByBookingId(Long id){
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public BookingImpl createBooking(BookingImpl booking){
        return bookingRepository.save(booking);
    }

    @Override
    public BookingImpl updateBooking(BookingImpl booking){
        return bookingRepository.save(booking);
    }

    @Override
    public void deleteBooking(Long id){
        bookingRepository.deleteById(id);
    }
    
}
