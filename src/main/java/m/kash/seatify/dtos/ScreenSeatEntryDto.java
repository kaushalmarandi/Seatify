package m.kash.seatify.dtos;

import lombok.Data;

@Data
public class ScreenSeatEntryDto {

    private String screenName;
    private int noOfSeatInRow;
    private int noOfSilverSeats;
    private int noOfGoldSeats;
    private int noOfPlatinumSeats;
}
