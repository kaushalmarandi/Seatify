package m.kash.bookmyshowoct24.repositories;

import m.kash.bookmyshowoct24.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    Optional<Show> findById(Long showId);
    @Query(value = "select time from shows where date = :date and movie_id = :movieId", nativeQuery = true)
    public List<Time> getShowTimingsOnDate(@Param("date")Date date, @Param("movieId")Integer movieId);

    @Query(value = "select * from shows where movie_id = :movieId", nativeQuery = true)
    public List<Show> getAllShowsOfMovie(@Param("movieId")Integer movieId);
}


