package m.kash.seatify.exceptions;

public class RequestedSeatsUnavailableException extends RuntimeException{
    public RequestedSeatsUnavailableException(){
        super("The selected seats are either unavailable or already booked");
    }
}

