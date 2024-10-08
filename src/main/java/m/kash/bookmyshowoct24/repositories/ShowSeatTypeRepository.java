package m.kash.bookmyshowoct24.repositories;

import m.kash.bookmyshowoct24.models.Show;
import m.kash.bookmyshowoct24.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {

    List<ShowSeatType> findAllByShow(Show show);
}
