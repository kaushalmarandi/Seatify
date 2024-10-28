package m.kash.bookmyshowoct24.transformers;

import m.kash.bookmyshowoct24.dtos.UserSignUpRequestDto;
import m.kash.bookmyshowoct24.models.User;


public class UserTransformer {


    public static User userSignUpDtoToUser(UserSignUpRequestDto requestDto){
        User user = User.builder().
                name(requestDto.getName())
                .email(requestDto.getEmail())
                .password(requestDto.getPassword())
                .build();

        return user;
    }
}
