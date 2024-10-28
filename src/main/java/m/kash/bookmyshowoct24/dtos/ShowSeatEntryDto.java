package m.kash.bookmyshowoct24.dtos;

import lombok.Data;

@Data
public class ShowSeatEntryDto {
    private Long showId;
    private Integer priceOfSilverSeat;
    private Integer priceOfGoldSeat;
    private Integer priceOfPlatinumSeat;
}
