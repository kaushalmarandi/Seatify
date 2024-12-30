package m.kash.seatify.dtos;

import lombok.Data;
import m.kash.seatify.enums.ScreenType;

@Data
public class ScreenEntryDto {
    private String name;
    private ScreenType screenType;
}
