package m.kash.seatify.services;

import m.kash.seatify.dtos.UserSignUpRequestDto;
import m.kash.seatify.exceptions.UserAlreadyPresentException;
import m.kash.seatify.models.User;
import m.kash.seatify.repositories.UserRepository;
import m.kash.seatify.transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserSignUpService {

    @Autowired
    private UserRepository userRepository;



    public String signUp(UserSignUpRequestDto userSignUpRequestDto){
        Optional<User> userOpt = userRepository.findByEmail(userSignUpRequestDto.getEmail());
        User savedUser = null;

        if (userOpt.isPresent()){
            throw new UserAlreadyPresentException();
        }
        User user = UserTransformer.userSignUpDtoToUser(userSignUpRequestDto);
        userRepository.save(user);

        return "User signUp Successfull!";
    }
}
