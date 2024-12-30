package m.kash.seatify.exceptions;

public class UserAlreadyPresentException extends RuntimeException{
    public UserAlreadyPresentException(){
        super("User Already exists with this email");
    }
}

