package m.kash.bookmyshowoct24.dtos;

import lombok.Data;

@Data
public class UserSignUpRequestDto {
    private String name;
    private String email;
    private String password;
}
