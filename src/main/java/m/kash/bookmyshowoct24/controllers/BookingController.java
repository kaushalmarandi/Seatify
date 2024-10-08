package m.kash.bookmyshowoct24.controllers;

import m.kash.bookmyshowoct24.dtos.BookMovieRequestDto;
import m.kash.bookmyshowoct24.dtos.BookMovieResponseDto;
import m.kash.bookmyshowoct24.dtos.ResponseStatus;
import m.kash.bookmyshowoct24.exceptions.ShowNotFoundException;
import m.kash.bookmyshowoct24.exceptions.UserNotFoundException;
import m.kash.bookmyshowoct24.models.Booking;
import m.kash.bookmyshowoct24.services.BookingService;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService){
        this.bookingService=bookingService;
    }
    public BookMovieResponseDto bookMovie(BookMovieRequestDto requestDto) throws UserNotFoundException, ShowNotFoundException {
       BookMovieResponseDto responseDto= new BookMovieResponseDto();

        try {
           Booking booking = bookingService.bookMovie(
                   requestDto.getUserId(),
                   requestDto.getShowId(),
                   requestDto.getShowSeatIds()
           );
           responseDto.setBooking(booking);
           responseDto.setResponseStatus(ResponseStatus.SUCCESS);
       }catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}
