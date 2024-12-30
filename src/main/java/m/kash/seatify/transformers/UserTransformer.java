package m.kash.seatify.transformers;

import m.kash.seatify.dtos.UserSignUpRequestDto;
import m.kash.seatify.models.User;


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
