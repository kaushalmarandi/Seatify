package m.kash.seatify.dtos;

import lombok.Data;

@Data
public class UserSignUpRequestDto {
    private String name;
    private String email;
    private String password;
}
