package m.kash.bookmyshowoct24.exceptions;

public class ScreenDoesNotExistException extends RuntimeException{
    public ScreenDoesNotExistException(){
        super("Screen does not exist");
    }
}

