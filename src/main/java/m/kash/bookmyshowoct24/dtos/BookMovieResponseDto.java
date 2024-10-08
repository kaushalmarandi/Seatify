package m.kash.bookmyshowoct24.dtos;

import lombok.Getter;
import lombok.Setter;
import m.kash.bookmyshowoct24.models.Booking;
@Getter
@Setter
public class BookMovieResponseDto {
    private Booking booking;
    private ResponseStatus responseStatus;
}
