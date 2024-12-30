package m.kash.seatify.exceptions;

public class ShowDoesNotExistException extends RuntimeException{
    public ShowDoesNotExistException(){
        super("Show does not exist");
    }
}
