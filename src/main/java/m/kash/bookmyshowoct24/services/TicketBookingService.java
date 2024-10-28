package m.kash.bookmyshowoct24.services;

import m.kash.bookmyshowoct24.dtos.TicketEntryDto;
import m.kash.bookmyshowoct24.dtos.TicketResponseDto;
import m.kash.bookmyshowoct24.enums.SeatStatus;
import m.kash.bookmyshowoct24.enums.SeatType;
import m.kash.bookmyshowoct24.exceptions.RequestedSeatsUnavailableException;
import m.kash.bookmyshowoct24.exceptions.ShowDoesNotExistException;
import m.kash.bookmyshowoct24.exceptions.UserDoesNotExistException;
import m.kash.bookmyshowoct24.models.Show;
import m.kash.bookmyshowoct24.models.ShowSeat;
import m.kash.bookmyshowoct24.models.Ticket;
import m.kash.bookmyshowoct24.models.User;
import m.kash.bookmyshowoct24.repositories.MovieRepository;
import m.kash.bookmyshowoct24.repositories.ShowRepository;
import m.kash.bookmyshowoct24.repositories.TicketRepository;
import m.kash.bookmyshowoct24.repositories.UserRepository;
import m.kash.bookmyshowoct24.transformers.TicketTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketBookingService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender javaMailSender;



    @Transactional(isolation = Isolation.SERIALIZABLE)
    public TicketResponseDto ticketBooking(TicketEntryDto ticketEntryDto)throws RequestedSeatsUnavailableException, UserDoesNotExistException, ShowDoesNotExistException {
        //check if the user exists
        Optional<User> userOpt = userRepository.findByEmail(ticketEntryDto.getUserEmail());
        if (userOpt.isEmpty()){
            throw new UserDoesNotExistException();
        }

        //check if the show exist
        Optional<Show> showOpt = showRepository.findById((long) ticketEntryDto.getShowId());
        if (showOpt.isEmpty()){
            throw new ShowDoesNotExistException();
        }

        User user = userOpt.get();
        System.out.println(user);
        Show show = showOpt.get();
        System.out.println(show);

        //check if requested seats are available
        Boolean isSeatAvailable = isSeatAvailable(show.getShowSeats(), ticketEntryDto.getRequestSeats(), ticketEntryDto.getSeatType());
        if (!isSeatAvailable){
            throw new RequestedSeatsUnavailableException();
        }

        //get total price
        int getPriceAndAssignSeats = getPriceAndAssignSeats(show.getShowSeats(), ticketEntryDto.getRequestSeats(), ticketEntryDto.getSeatType());
        System.out.println(getPriceAndAssignSeats);

        //change list to string
        String seats = listToString(ticketEntryDto.getRequestSeats());
        System.out.println(seats);

        //create ticket entity and set all attribute
        Ticket ticket = new Ticket();
        ticket.setTotalTicketsPrice(getPriceAndAssignSeats);
        ticket.setBookedSeats(seats);
        ticket.setSeatType(ticketEntryDto.getSeatType());
        ticket.setUser(user);
        ticket.setShow(show);

        ticket=ticketRepository.save(ticket);

//        userRepository.save(user);
//        showRepository.save(show);

        //send confirmation mail to user
        sendMailToUser(user, show, seats);

        return TicketTransformer.returnTicket(show, ticket);



    }

    public void sendMailToUser(User user, Show show, String seats){
        String body = "Dear " + user.getName() + ",\n\nI hope this email finds you well. \n" +
                "I am writing to inform you that your ticket has been successfully booked. \n" +
                "We are pleased to confirm that your preferred date, time and other details have been secured. \n " +
                "Ticket Details:\n\n" +
                "Booked seat No's: " +seats+"\n" +
                "Movie name: " + show.getMovie().getName() + "\n" +
                "Date: " + show.getShowDate() + "\n" +
                "Time: " + show.getStartTime() + "\n" +
                "Screen: " + show.getScreen().getName() + "\n" + "\n\n" +
                "Enjoy the show!!";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setText(body);
        message.setFrom("devtestkaushal@gmail.com");
        message.setTo(user.getEmail());
        message.setSubject("Ticket Successfully Booked!");
        javaMailSender.send(message);
    }

    private Boolean isSeatAvailable(List<ShowSeat> showSeatList, List<String> requestSeats, SeatType seatType){
        for (ShowSeat showSeat: showSeatList){
            String seatNo = showSeat.getSeatNo();
            if (requestSeats.contains(seatNo) && showSeat.getSeatType().equals(seatType)){
                if (showSeat.getSeatStatus().equals(SeatStatus.BOOKED)){
                    return false;
                }
            }
        }
        return true;

    }

    private int getPriceAndAssignSeats(List<ShowSeat> showSeatList, List<String> requestSeats, SeatType seatType){
        int totalAmount = 0;
        for (ShowSeat showSeat: showSeatList){
            if (requestSeats.contains(showSeat.getSeatNo()) && showSeat.getSeatType().equals(seatType)){
                totalAmount += showSeat.getPrice();
                showSeat.setSeatStatus(SeatStatus.BOOKED);
            }
        }
        return totalAmount;
    }

    private String listToString(List<String> requestSeats) {
        return requestSeats.stream()
                .collect(Collectors.joining(",")); // Collect and join with a comma
    }



}

