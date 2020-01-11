package nc.Medas.service;

import nc.Medas.exception.EntityNotFoundException;
import nc.Medas.model.Screen;
import nc.Medas.model.Ticket;
import nc.Medas.model.User;
import nc.Medas.repo.ScreenRepo;
import nc.Medas.repo.TicketRepo;
import nc.Medas.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TicketService {

    private final UserRepo userRepo;

    private final ScreenRepo screenRepo;

    private final Logger LOG = LoggerFactory.getLogger(TicketService.class);

    private TicketRepo ticketRepo;

    public TicketService(UserRepo userRepo, ScreenRepo screenRepo, TicketRepo ticketRepo) {
        this.userRepo = userRepo;
        this.screenRepo = screenRepo;
        this.ticketRepo = ticketRepo;
    }

    private boolean hasMoneyForFilm(User user, Screen screen) {
        return user.getMoney() >= screen.getPrice();
    }

    @Transactional
    public Ticket save(Ticket ticket) {

        User user = userRepo.findById(ticket.getUser().getId())
                .orElseThrow(() -> new EntityNotFoundException(ticket.getUser().getId() + " id"));

        Screen screen = screenRepo.findById(ticket.getScreen().getId())
                .orElseThrow(() -> new EntityNotFoundException(ticket.getScreen().getId() + "id"));

        if (hasMoneyForFilm(user, screen)) {
            try {
                userRepo.setFixedMoneyFor(user.getId(), user.getMoney() - screen.getPrice());
                return ticketRepo.save(ticket);
            } catch (DataIntegrityViolationException e) {
                LOG.error(" Attempt to buy busy seat! ");
                throw new ResponseStatusException(
                        HttpStatus.CONFLICT, "Seat is busy");
            }

        }
        else {
            LOG.error("Not enough money for the ticket");
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Not enough money!");
        }


    }

    public List<Ticket> findTicketsByUser(User user) {
        return ticketRepo.findTicketsByUser(user);
    }

    public List<Ticket> findAll() {
        return ticketRepo.findAll();
    }

    public List<Ticket> getBusySeats(Screen screen) {
        return ticketRepo.findTicketsByScreen(screen);
    }
}
