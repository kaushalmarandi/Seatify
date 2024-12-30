package m.kash.seatify.controllers;

import m.kash.seatify.dtos.TicketEntryDto;
import m.kash.seatify.dtos.TicketResponseDto;
import m.kash.seatify.services.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketBookingService service;

    @PostMapping("/book")
    @ResponseBody
    public ResponseEntity<TicketResponseDto> ticketBooking(@RequestBody TicketEntryDto ticketEntryDto){
        try {
            TicketResponseDto result = service.ticketBooking(ticketEntryDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
