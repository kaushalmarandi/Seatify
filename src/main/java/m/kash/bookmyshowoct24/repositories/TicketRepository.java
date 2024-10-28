package m.kash.bookmyshowoct24.repositories;

import m.kash.bookmyshowoct24.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{
}
