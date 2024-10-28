package m.kash.bookmyshowoct24.transformers;

import m.kash.bookmyshowoct24.dtos.ShowEntryDto;
import m.kash.bookmyshowoct24.models.Show;

public class ShowTransformer {

    public static Show showDtoToShow(ShowEntryDto showEntryDto){
        Show show = Show.builder()
                .startTime(showEntryDto.getShowStartTime())
                .showDate(showEntryDto.getShowDate())
                .build();

        return show;
    }
}
