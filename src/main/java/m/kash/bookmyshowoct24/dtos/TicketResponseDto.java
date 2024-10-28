package m.kash.bookmyshowoct24.dtos;

import lombok.Builder;
import lombok.Data;
import m.kash.bookmyshowoct24.enums.SeatType;

import java.sql.Date;
import java.sql.Time;

@Data
@Builder
public class TicketResponseDto {
    private Time time;
    private Date date;
    private String movieName;
    private String Screen;
    private SeatType seatType;
    private String bookedSeats;
    private int totalPrice;
}
