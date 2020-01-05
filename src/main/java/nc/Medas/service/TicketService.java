package nc.Medas.service;

import nc.Medas.model.Screen;
import nc.Medas.model.Ticket;
import nc.Medas.model.User;
import nc.Medas.repo.ScreenRepo;
import nc.Medas.repo.TicketRepo;
import nc.Medas.repo.UserRepo;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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

        User user = userRepo.findById(ticket.getUser().getId()).orElse(new User());
        Screen screen = screenRepo.findById(ticket.getScreen().getId()).orElse(new Screen());
        if (hasMoneyForFilm(user, screen)) {
            try {
                userRepo.setFixedMoneyFor(user.getId(),user.getMoney()-screen.getPrice());
                return ticketRepo.save(ticket);
            } catch (ConstraintViolationException e) {
                LOG.error(e.getMessage() + "Попытка купить занятое место");
            }

        }

        return new Ticket();
    }

    public List<Ticket> findTicketsByUser(User user) {
        return ticketRepo.findTicketsByUser(user);
    }

    public List<Ticket> findAll() {
        return ticketRepo.findAll();
    }

    public Ticket findTicketByUserId(int id) {
        return ticketRepo.findById(id).orElse(new Ticket());
    }

}
