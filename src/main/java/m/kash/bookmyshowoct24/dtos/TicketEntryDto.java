package m.kash.bookmyshowoct24.dtos;

import lombok.Data;

import java.util.List;

@Data
public class TicketEntryDto {

    private Long showId;
    private String  userEmail;
    private List<String> requestSeats;
}
