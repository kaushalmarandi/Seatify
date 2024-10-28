package m.kash.bookmyshowoct24.transformers;

import m.kash.bookmyshowoct24.dtos.MovieEntryDto;
import m.kash.bookmyshowoct24.enums.Genre;
import m.kash.bookmyshowoct24.enums.Language;
import m.kash.bookmyshowoct24.models.Movie;

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
