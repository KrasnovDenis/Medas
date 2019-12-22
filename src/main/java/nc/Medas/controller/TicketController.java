package nc.Medas.controller;

import nc.Medas.model.Ticket;
import nc.Medas.repo.UserRepo;
import nc.Medas.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RequestMapping("/tickets")
@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserRepo userRepo;

    @PostMapping
    public Ticket saveTicket(@RequestBody Ticket ticket) throws SQLException {
        return ticketService.saveTicketByTicket(ticket);
    }

    @GetMapping("{id}")
    public List<Ticket> getTicket(@PathVariable("id") int idUser) throws SQLException {
        return ticketService.getTicketsByUser(userRepo.findById(idUser).get());
    }

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }


}
