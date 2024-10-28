package m.kash.bookmyshowoct24.services;

import m.kash.bookmyshowoct24.dtos.UserSignUpRequestDto;
import m.kash.bookmyshowoct24.exceptions.UserAlreadyPresentException;
import m.kash.bookmyshowoct24.models.User;
import m.kash.bookmyshowoct24.repositories.UserRepository;
import m.kash.bookmyshowoct24.transformers.UserTransformer;
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
