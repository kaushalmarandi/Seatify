package m.kash.bookmyshowoct24.dtos;

import lombok.Data;
import m.kash.bookmyshowoct24.enums.ScreenType;

@Data
public class ScreenEntryDto {
    private String name;
    private ScreenType screenType;
}
