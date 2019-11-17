package nc.Medas.repo;

import nc.Medas.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Ticket,Integer> {
}
