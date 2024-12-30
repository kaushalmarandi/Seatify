package m.kash.seatify.repositories;

import m.kash.seatify.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{
}
