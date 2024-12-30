package m.kash.seatify.transformers;

import m.kash.seatify.dtos.ScreenEntryDto;
import m.kash.seatify.models.Screen;

public class ScreenTransformer {

    public static Screen screenDtoToScreen(ScreenEntryDto screenEntryDto){
        Screen screen = Screen.builder()
                .name(screenEntryDto.getName())
                .screenType(screenEntryDto.getScreenType()).
                build();

        return screen;
    }
}
