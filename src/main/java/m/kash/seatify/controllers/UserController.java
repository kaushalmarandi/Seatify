package m.kash.seatify.controllers;

import m.kash.seatify.dtos.UserSignUpRequestDto;
import m.kash.seatify.services.UserSignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserSignUpService userSignUpService;

    @PostMapping("/addNew")
    public ResponseEntity<String> userSignUp(@RequestBody UserSignUpRequestDto userSignUpRequestDto){
        try {
            String result = userSignUpService.signUp(userSignUpRequestDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
