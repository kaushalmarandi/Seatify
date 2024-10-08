package m.kash.bookmyshowoct24.controllers;

import m.kash.bookmyshowoct24.dtos.ResponseStatus;
import m.kash.bookmyshowoct24.dtos.SignUpRequestDto;
import m.kash.bookmyshowoct24.dtos.SignUpResponseDto;
import m.kash.bookmyshowoct24.models.User;
import m.kash.bookmyshowoct24.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }
    public SignUpResponseDto signUp(SignUpRequestDto requestDto){
        SignUpResponseDto responseDto= new SignUpResponseDto();

        try {
            User user = userService.signUp(requestDto.getName(),
                    requestDto.getEmail(),
                    requestDto.getPassword());

            responseDto.setUser(user);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}
