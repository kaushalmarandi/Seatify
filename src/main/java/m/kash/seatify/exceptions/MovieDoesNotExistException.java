package m.kash.seatify.exceptions;

public class MovieDoesNotExistException extends RuntimeException{
    public MovieDoesNotExistException(){
        super("Movie does not exist");
    }
}
