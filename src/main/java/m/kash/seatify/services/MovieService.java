package m.kash.seatify.services;

import m.kash.seatify.dtos.MovieEntryDto;
import m.kash.seatify.exceptions.MovieAlreadyExistException;
import m.kash.seatify.models.Movie;
import m.kash.seatify.repositories.MovieRepository;
import m.kash.seatify.repositories.ShowRepository;
import m.kash.seatify.transformers.MovieTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
