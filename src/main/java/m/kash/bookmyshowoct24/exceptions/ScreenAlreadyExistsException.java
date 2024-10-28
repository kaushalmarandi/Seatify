package m.kash.bookmyshowoct24.exceptions;

public class ScreenAlreadyExistsException extends RuntimeException{
    public ScreenAlreadyExistsException(){
        super("Screen already exist");
    }
}