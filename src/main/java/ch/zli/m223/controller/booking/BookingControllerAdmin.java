package ch.zli.m223.controller.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zli.m223.model.Booking;
import ch.zli.m223.model.impl.BookingImpl;
import ch.zli.m223.service.booking.BookingService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/v1/admin/bookings")
public class BookingControllerAdmin {
    
    @Autowired
    private BookingService bookingService;

    @GetMapping
    List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @GetMapping("/{bookingId}")
    Booking getBookingByBookingId(@PathVariable("bookingId") Long bookingId){
        return bookingService.getBookingByBookingId(bookingId);
    }

    @GetMapping("/{userId}")
    List<BookingImpl> getBookingByUserId(@PathVariable("userId") Long userId){
        return bookingService.getBookingByUserId(userId);
    }

    @GetMapping("/{date}")
    List<BookingImpl> getBookingByDate(@RequestParam("date") String date){
        return bookingService.getBookingByDate(date);
    }
    

    @PostMapping
    public BookingImpl createBooking(@RequestBody Long userid, String bookingDate, Booking.Duration duration){
        return bookingService.createBooking(userid, bookingDate, duration);
    }

    @PutMapping("/{id}")
    public BookingImpl updateBookingStatus(@PathVariable("id") Long id, Booking.BookingStatus status){
        return bookingService.updateBookingStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable("id") Long id){
        bookingService.deleteBooking(id);
    }
}
