package m.kash.bookmyshowoct24.services;

import m.kash.bookmyshowoct24.dtos.ShowEntryDto;
import m.kash.bookmyshowoct24.dtos.ShowSeatEntryDto;
import m.kash.bookmyshowoct24.dtos.ShowTimingsDto;
import m.kash.bookmyshowoct24.enums.SeatStatus;
import m.kash.bookmyshowoct24.enums.SeatType;
import m.kash.bookmyshowoct24.exceptions.MovieDoesNotExistException;
import m.kash.bookmyshowoct24.exceptions.ScreenDoesNotExistException;
import m.kash.bookmyshowoct24.exceptions.ShowDoesNotExistException;
import m.kash.bookmyshowoct24.models.*;
import m.kash.bookmyshowoct24.repositories.MovieRepository;
import m.kash.bookmyshowoct24.repositories.ScreenRepository;
import m.kash.bookmyshowoct24.repositories.ShowRepository;
import m.kash.bookmyshowoct24.transformers.ShowTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ScreenRepository screenRepository;

    public String addShow(ShowEntryDto showEntryDto) throws MovieDoesNotExistException, ScreenDoesNotExistException {
        Show show = ShowTransformer.showDtoToShow(showEntryDto);

        Optional<Movie> movieOpt = movieRepository.findById(showEntryDto.getMovieId());
        if (movieOpt.isEmpty()){
            throw new MovieDoesNotExistException();
        }
        Optional<Screen> screenOpt = screenRepository.findById(showEntryDto.getScreenId());
        if (screenOpt.isEmpty()){
            throw new ScreenDoesNotExistException();
        }

        Screen screen = screenOpt.get();
        Movie movie = movieOpt.get();

        show.setMovie(movie);
        show.setScreen(screen);
        show = showRepository.save(show);

        movie.getShows().add(show);
        screen.getShows().add(show);

        movieRepository.save(movie);
        screenRepository.save(screen);

        return "Show has been added successfully";
    }

    public String associateShowSeats(ShowSeatEntryDto showSeatEntryDto)throws ShowDoesNotExistException{
        Optional<Show> showOpt = showRepository.findById(showSeatEntryDto.getShowId());
        if (showOpt.isEmpty()){
            throw new ShowDoesNotExistException();
        }
        Show show = showOpt.get();
        Screen screen = show.getScreen();

        List<ScreenSeat> screenSeats = screen.getScreenSeats();

        List<ShowSeat> showSeats = show.getShowSeats();
        for (ScreenSeat screenSeat: screenSeats){
            ShowSeat showSeat = new ShowSeat();
            showSeat.setSeatNo(screenSeat.getSeatNo());
            showSeat.setSeatType(screenSeat.getSeatType());

            if (showSeat.getSeatType().equals(SeatType.SILVER)){
                showSeat.setPrice(showSeatEntryDto.getPriceOfSilverSeat());
            } else if (showSeat.getSeatType().equals(SeatType.GOLD)) {
                showSeat.setPrice(showSeatEntryDto.getPriceOfGoldSeat());
            }else{
                showSeat.setPrice(showSeatEntryDto.getPriceOfPlatinumSeat());
            }

            showSeat.setShow(show);
            showSeat.setSeatStatus(SeatStatus.AVAILABLE);
            showSeats.add(showSeat);
        }

        showRepository.save(show);

        return "Show seats have been assoiated Successfully";
    }

    public List<Time> showTimingsOnDate(ShowTimingsDto showTimingsDto){
        Date date = showTimingsDto.getDate();
        int movieId = showTimingsDto.getMovieId();
        return showRepository.getShowTimingsOnDate(date, movieId);
    }

}
