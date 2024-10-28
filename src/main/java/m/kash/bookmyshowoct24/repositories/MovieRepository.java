package m.kash.bookmyshowoct24.repositories;

import m.kash.bookmyshowoct24.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findMovieByName(String name);
}
