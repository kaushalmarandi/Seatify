package m.kash.seatify.exceptions;

public class ScreenDoesNotExistException extends RuntimeException{
    public ScreenDoesNotExistException(){
        super("Screen does not exist");
    }
}

