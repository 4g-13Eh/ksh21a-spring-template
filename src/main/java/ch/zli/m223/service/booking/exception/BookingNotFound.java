package ch.zli.m223.service.booking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Booking does not exist")
public class BookingNotFound extends RuntimeException{
    
}
