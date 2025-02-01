package m.kash.seatify.transformers;

import m.kash.seatify.dtos.UserSignUpRequestDto;
import m.kash.seatify.models.User;


public class UserTransformer {


    public static User userSignUpDtoToUser(UserSignUpRequestDto requestDto, String encodedPassword){
        User user = User.builder().
                name(requestDto.getName())
                .email(requestDto.getEmail())
                .password(encodedPassword)
                .build();

        return user;
    }
}
