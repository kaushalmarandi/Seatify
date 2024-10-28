package m.kash.bookmyshowoct24.services;

import m.kash.bookmyshowoct24.dtos.MovieEntryDto;
import m.kash.bookmyshowoct24.exceptions.MovieAlreadyExistException;
import m.kash.bookmyshowoct24.exceptions.MovieDoesNotExistException;
import m.kash.bookmyshowoct24.models.Movie;
import m.kash.bookmyshowoct24.models.Show;
import m.kash.bookmyshowoct24.models.Ticket;
import m.kash.bookmyshowoct24.repositories.MovieRepository;
import m.kash.bookmyshowoct24.repositories.ShowRepository;
import m.kash.bookmyshowoct24.transformers.MovieTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ShowRepository showRepository;

    public String addMovie(MovieEntryDto movieEntryDto) throws MovieAlreadyExistException {
        if(movieRepository.findMovieByName(movieEntryDto.getMovieName()) !=null) {
            if (movieRepository.findMovieByName(movieEntryDto.getMovieName()).getLanguage().equals(movieEntryDto.getLanguage())){
                throw new MovieAlreadyExistException();
            }
        }
        Movie movie= MovieTransformer.movieDtoToMovie(movieEntryDto);
        movieRepository.save(movie);
        return "The movie has been added successfully";

    }


}
