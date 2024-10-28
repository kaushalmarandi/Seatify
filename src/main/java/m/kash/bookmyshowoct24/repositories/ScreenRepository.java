package m.kash.bookmyshowoct24.repositories;

import m.kash.bookmyshowoct24.models.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreenRepository extends JpaRepository<Screen, Integer> {
    Screen findScreenByName(String name);
}
