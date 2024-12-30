package m.kash.seatify.transformers;

import m.kash.seatify.dtos.TicketResponseDto;
import m.kash.seatify.models.Show;
import m.kash.seatify.models.Ticket;

import java.sql.Date;

public class TicketTransformer {

    public static TicketResponseDto returnTicket(Show show, Ticket ticket){
        TicketResponseDto ticketResponseDto = TicketResponseDto.builder()
                .bookedSeats(ticket.getBookedSeats())
                .date((Date) show.getShowDate())
                .movieName(show.getMovie().getName())
                .time(show.getStartTime())
                .seatType(ticket.getSeatType())
                .Screen(show.getScreen().getName())
                .totalPrice(ticket.getTotalTicketsPrice())
                .build();

        return ticketResponseDto;
    }
}
