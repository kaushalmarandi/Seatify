package m.kash.seatify.exceptions;

public class ScreenAlreadyExistsException extends RuntimeException{
    public ScreenAlreadyExistsException(){
        super("Screen already exist");
    }
}