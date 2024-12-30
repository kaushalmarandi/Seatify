package m.kash.seatify.services;

import m.kash.seatify.dtos.ScreenEntryDto;
import m.kash.seatify.dtos.ScreenSeatEntryDto;
import m.kash.seatify.enums.SeatType;
import m.kash.seatify.exceptions.ScreenAlreadyExistsException;
import m.kash.seatify.exceptions.ScreenDoesNotExistException;
import m.kash.seatify.models.Screen;
import m.kash.seatify.models.ScreenSeat;
import m.kash.seatify.repositories.ScreenRepository;
import m.kash.seatify.transformers.ScreenTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
 public class ScreenService {

     @Autowired
     private ScreenRepository screenRepository;

     public String addScreen(ScreenEntryDto screenEntryDto) throws ScreenAlreadyExistsException {
         if (screenRepository.findScreenByName(screenEntryDto.getName()) != null) {
             throw new ScreenAlreadyExistsException();
         }
         Screen screen = ScreenTransformer.screenDtoToScreen(screenEntryDto);
         screenRepository.save(screen);
         return "Screen has been added Successfully";
     }

     public String addScreenSeat(ScreenSeatEntryDto screenSeatEntryDto) throws ScreenDoesNotExistException {
         // Check if the screen exists
         Screen screen = screenRepository.findScreenByName(screenSeatEntryDto.getScreenName());
         if (screen == null) {
             throw new ScreenDoesNotExistException();
         }

         // Get seat details
         int noOfSeatsInRow = screenSeatEntryDto.getNoOfSeatInRow();
         Map<SeatType, Integer> seatTypeCounts = Map.of(
                 SeatType.SILVER, screenSeatEntryDto.getNoOfSilverSeats(),
                 SeatType.GOLD, screenSeatEntryDto.getNoOfGoldSeats(),
                 SeatType.PLATINUM, screenSeatEntryDto.getNoOfPlatinumSeats()
         );

         // Add seats for each type
         seatTypeCounts.forEach((seatType, count) -> addSeats(count, seatType, screen, screen.getScreenSeats(), noOfSeatsInRow));

         // Save the updated screen back to the repository
         screenRepository.save(screen);
         return "Screen seats have been added successfully";
     }

     private void addSeats(int numberOfSeats, SeatType seatType, Screen screen, List<ScreenSeat> screenSeats, int noOfSeatsInRow) {
         int rowCounter = 0; // Start from 0 for row indexing
         int seatsInCurrentRow = 0;
         char seatChar = 'A'; // Start with the first row character

         for (int i = 0; i < numberOfSeats; i++) {
             // Create a seat number in the format "A1", "A2", etc.
             String seatNo = seatChar + String.valueOf(seatsInCurrentRow + 1);

             // Create a new ScreenSeat object
             ScreenSeat screenSeat = new ScreenSeat();
             screenSeat.setSeatNo(seatNo);
             screenSeat.setSeatType(seatType);
             screenSeat.setScreen(screen);

             // Add to the list of seats
             screenSeats.add(screenSeat);

             // Increment the current seat index
             seatsInCurrentRow++;

             // If the row is full, reset the seat index and move to the next row
             if (seatsInCurrentRow == noOfSeatsInRow) {
                 seatsInCurrentRow = 0; // Reset for the next row
                 rowCounter++; // Increment the row
                 seatChar++; // Move to the next row character (A -> B, etc.)
             }
         }
     }

 }


