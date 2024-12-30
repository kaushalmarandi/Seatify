package m.kash.seatify.exceptions;

public class MovieAlreadyExistException extends RuntimeException{
    public MovieAlreadyExistException(){
        super("Movie with same name and language alreay exist");
    }
}