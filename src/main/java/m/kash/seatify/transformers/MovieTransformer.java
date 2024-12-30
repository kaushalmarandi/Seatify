package m.kash.seatify.transformers;

import m.kash.seatify.dtos.MovieEntryDto;
import m.kash.seatify.enums.Genre;
import m.kash.seatify.enums.Language;
import m.kash.seatify.models.Movie;

public class MovieTransformer {
    public static Movie movieDtoToMovie(MovieEntryDto movieEntryDto){
        Movie movie=Movie.builder()
                .name(movieEntryDto.getMovieName())
                .genre(Genre.valueOf(movieEntryDto.getGenre()))
                .language(Language.valueOf(movieEntryDto.getLanguage()))
                .build();

        return movie;
    }
}
