package m.kash.bookmyshowoct24.dtos;

import lombok.Data;
import m.kash.bookmyshowoct24.enums.SeatType;

import java.util.List;

@Data
public class TicketEntryDto {

    private Long showId;
    private String  userEmail;
    private SeatType seatType;
    private List<String> requestSeats;
}
