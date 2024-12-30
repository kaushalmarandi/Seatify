package m.kash.seatify.dtos;

import lombok.Data;
import m.kash.seatify.enums.SeatType;

import java.util.List;

@Data
public class TicketEntryDto {

    private Long showId;
    private String  userEmail;
    private SeatType seatType;
    private List<String> requestSeats;
}
