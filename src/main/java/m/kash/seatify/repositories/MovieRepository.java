package m.kash.seatify.repositories;

import m.kash.seatify.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findMovieByName(String name);
}
