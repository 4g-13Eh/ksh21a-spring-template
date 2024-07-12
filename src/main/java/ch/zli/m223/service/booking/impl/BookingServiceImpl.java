package ch.zli.m223.service.booking.impl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zli.m223.model.AppUser;
import ch.zli.m223.model.Booking;
import ch.zli.m223.model.impl.BookingImpl;
import ch.zli.m223.repository.BookingRepository;
import ch.zli.m223.service.booking.BookingService;
import ch.zli.m223.service.booking.exception.BookingNotFound;
import ch.zli.m223.service.user.UserService;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserService userService;

    public BookingServiceImpl(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> getAllBookings() {
        return new ArrayList<Booking>(bookingRepository.findAll());
    }

    @Override
    public Booking getBookingByBookingId(Long bookingId){
        return bookingRepository.findById(bookingId).orElseThrow(()-> new BookingNotFound());
    }


    @Override
    public Booking getBookingMemberByBookingId(Long bookingId, Principal principal){
        AppUser user = userService.getUserByName(principal.getName());
        Long senderUserId = user.getId();
        Booking booking = bookingRepository.findById(bookingId).orElse(null);
        Long searchedBookingUserId = booking.getUserId();
        System.out.println("Sender: " + senderUserId + " Searched: " + searchedBookingUserId);
        if(senderUserId == searchedBookingUserId){
            return bookingRepository.findById(bookingId).orElseThrow(()-> new BookingNotFound());
        } else {
            throw new BookingNotFound();
        }
    }

    @Override
    public List<BookingImpl> getBookingByDate(String date){
        return bookingRepository.findByBookingDate(date);
    }

    @Override
    public List<BookingImpl> getMemberBookingsByUserId(Long userId, Principal principal){
        AppUser user = userService.getUserByName(principal.getName());
        Long senderUserId = user.getId();
        if(senderUserId == userId){
            return bookingRepository.findByUserId(userId);
        } else {
            throw new BookingNotFound();
        }
    }

    @Override
    public List<BookingImpl> getBookingsByUserId(Long userId){
        return bookingRepository.findByUserId(userId);
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

    @Override
    public void deleteMemberBooking(Long id, Principal principal){
        AppUser user = userService.getUserByName(principal.getName());
        Long senderUserId = user.getId();
        Booking booking = bookingRepository.findById(id).orElseThrow(()-> new BookingNotFound());
        Long searchedBookingUserId = booking.getUserId();
        if(senderUserId == searchedBookingUserId){
            bookingRepository.deleteById(id);
        } else {
            throw new BookingNotFound();
        }
    }
    
}
