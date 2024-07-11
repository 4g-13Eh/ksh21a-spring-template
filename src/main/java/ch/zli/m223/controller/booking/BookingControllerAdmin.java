package ch.zli.m223.controller.booking;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zli.m223.controller.booking.dto.AdminBookingDto;
import ch.zli.m223.controller.booking.dto.StatusUpdateDto;
import ch.zli.m223.model.AppUser;
import ch.zli.m223.model.Booking;
import ch.zli.m223.model.impl.BookingImpl;
import ch.zli.m223.service.booking.BookingService;
import ch.zli.m223.service.user.UserService;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/v1/admin/bookings")
public class BookingControllerAdmin {
    
    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;

    @GetMapping
    List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @GetMapping("/{bookingId}")
    Booking getBookingByBookingId(@PathVariable("bookingId") Long bookingId){
        return bookingService.getBookingByBookingId(bookingId);
    }

    @GetMapping("/user/{userId}")
    List<BookingImpl> getBookingByUserId(@PathVariable("userId") Long userId){
        return bookingService.getBookingByUserId(userId);
    }

    @GetMapping("/date/{date}")
    List<BookingImpl> getBookingByDate(@PathVariable("date") String date){
        return bookingService.getBookingByDate(date);
    }
    

    @PostMapping
    public BookingImpl createBooking(@RequestBody AdminBookingDto bookingDto, Principal principal){
        AppUser user = userService.getUserByName(principal.getName());
        return bookingService.createBooking(user.getId(), bookingDto.getBookingDate(), bookingDto.getDuration());
    }

    @PatchMapping("/{id}")
    public BookingImpl updateBookingStatus(@PathVariable("id") Long id, StatusUpdateDto status){
        return bookingService.updateBookingStatus(id, status.getStatus());
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable("id") Long id){
        bookingService.deleteBooking(id);
    }
}
