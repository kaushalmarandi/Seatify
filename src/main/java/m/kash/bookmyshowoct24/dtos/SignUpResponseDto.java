package m.kash.bookmyshowoct24.dtos;

import lombok.Getter;
import lombok.Setter;
import m.kash.bookmyshowoct24.models.User;

@Getter
@Setter
public class SignUpResponseDto {
    private User user;
    private ResponseStatus responseStatus;
}
