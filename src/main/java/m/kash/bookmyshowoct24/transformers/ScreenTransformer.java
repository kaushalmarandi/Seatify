package m.kash.bookmyshowoct24.transformers;

import m.kash.bookmyshowoct24.dtos.ScreenEntryDto;
import m.kash.bookmyshowoct24.models.Screen;

public class ScreenTransformer {

    public static Screen screenDtoToScreen(ScreenEntryDto screenEntryDto){
        Screen screen = Screen.builder()
                .name(screenEntryDto.getName())
                .screenType(screenEntryDto.getScreenType()).
                build();

        return screen;
    }
}
