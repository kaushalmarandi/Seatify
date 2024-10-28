package m.kash.bookmyshowoct24.exceptions;

public class RequestedSeatsUnavailableException extends RuntimeException{
    public RequestedSeatsUnavailableException(){
        super("The selected seats are either unavailable or already booked");
    }
}

