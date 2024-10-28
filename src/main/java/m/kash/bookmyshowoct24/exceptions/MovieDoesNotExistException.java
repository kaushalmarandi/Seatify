package m.kash.bookmyshowoct24.exceptions;

public class MovieDoesNotExistException extends RuntimeException{
    public MovieDoesNotExistException(){
        super("Movie does not exist");
    }
}
