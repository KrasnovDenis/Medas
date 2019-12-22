package nc.Medas.repo;

import nc.Medas.model.Screen;
import nc.Medas.model.Ticket;
import nc.Medas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepo extends JpaRepository<Ticket,Integer> {
    Ticket findByScreen(Screen screen);
    List<Ticket> findTicketsByUser(User user);
}
