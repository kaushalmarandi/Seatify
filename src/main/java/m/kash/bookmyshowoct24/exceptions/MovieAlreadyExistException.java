package m.kash.bookmyshowoct24.exceptions;

public class MovieAlreadyExistException extends RuntimeException{
    public MovieAlreadyExistException(){
        super("Movie with same name and language alreay exist");
    }
}