package m.kash.seatify.repositories;

import m.kash.seatify.models.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreenRepository extends JpaRepository<Screen, Integer> {
    Screen findScreenByName(String name);
}
