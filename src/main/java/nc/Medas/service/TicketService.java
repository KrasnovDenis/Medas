package nc.Medas.service;

import nc.Medas.model.Screen;
import nc.Medas.model.Ticket;
import nc.Medas.model.User;
import nc.Medas.repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {


    private TicketRepo ticketRepo;

    public TicketService(TicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    private boolean hasMoneyForFilm(User user, Screen screen) {
        return user.getMoney() >= screen.getPrice();
    }

    public Ticket saveTicketByTicket(Ticket ticket) {
        if(hasMoneyForFilm(ticket.getUser(), ticket.getScreen()))
            return ticketRepo.save(ticket);
        return null;
    }

    public List<Ticket> getTicketsByUser (User user) {
        return ticketRepo.findTicketsByUser(user);
    }

    public List<Ticket> getAllTickets () {
        return ticketRepo.findAll();
    }

}
