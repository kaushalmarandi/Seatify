package m.kash.seatify.exceptions;

public class UserDoesNotExistException extends RuntimeException{
    public UserDoesNotExistException(){
        super("User is not available, please try User signUp!");
    }
}

