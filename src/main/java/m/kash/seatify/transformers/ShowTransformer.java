package m.kash.seatify.transformers;

import m.kash.seatify.dtos.ShowEntryDto;
import m.kash.seatify.models.Show;

public class ShowTransformer {

    public static Show showDtoToShow(ShowEntryDto showEntryDto){
        Show show = Show.builder()
                .startTime(showEntryDto.getShowStartTime())
                .showDate(showEntryDto.getShowDate())
                .build();

        return show;
    }
}
