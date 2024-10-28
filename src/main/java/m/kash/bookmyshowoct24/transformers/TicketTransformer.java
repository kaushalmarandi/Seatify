package m.kash.bookmyshowoct24.transformers;

import m.kash.bookmyshowoct24.dtos.TicketResponseDto;
import m.kash.bookmyshowoct24.models.Show;
import m.kash.bookmyshowoct24.models.Ticket;

import java.sql.Date;
import java.sql.Time;

public class TicketTransformer {

    public static TicketResponseDto returnTicket(Show show, Ticket ticket){
        TicketResponseDto ticketResponseDto = TicketResponseDto.builder()
                .bookedSeats(ticket.getBookedSeats())
                .date((Date) show.getShowDate())
                .movieName(show.getMovie().getName())
                .time(show.getStartTime())
                .Screen(show.getScreen().getName())
                .totalPrice(ticket.getTotalTicketsPrice())
                .build();

        return ticketResponseDto;
    }
}
