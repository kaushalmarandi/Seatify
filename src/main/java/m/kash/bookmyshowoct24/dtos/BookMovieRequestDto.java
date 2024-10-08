package m.kash.bookmyshowoct24.dtos;

import lombok.Getter;
import lombok.Setter;
import m.kash.bookmyshowoct24.models.ShowSeat;

import java.util.List;
@Getter
@Setter
public class BookMovieRequestDto {
    private Long userId;
    private Long showId;
    private List<Long> showSeatIds;
}
