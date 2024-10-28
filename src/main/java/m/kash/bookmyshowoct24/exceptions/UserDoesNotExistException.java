package m.kash.bookmyshowoct24.exceptions;

public class UserDoesNotExistException extends RuntimeException{
    public UserDoesNotExistException(){
        super("User is not available, please try User signUp!");
    }
}

