package m.kash.bookmyshowoct24.exceptions;

public class UserAlreadyPresentException extends RuntimeException{
    public UserAlreadyPresentException(){
        super("User Already exists with this email");
    }
}

