package m.kash.bookmyshowoct24.exceptions;

public class ShowDoesNotExistException extends RuntimeException{
    public ShowDoesNotExistException(){
        super("Show does not exist");
    }
}
