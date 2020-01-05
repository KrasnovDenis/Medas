package nc.Medas.controller;

import nc.Medas.model.Ticket;
import nc.Medas.service.TicketService;
import nc.Medas.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tickets")
@RestController
public class TicketController {


    private final TicketService ticketService;
    private final UserService userService;

    public TicketController(TicketService ticketService, UserService userService) {
        this.ticketService = ticketService;
        this.userService = userService;
    }

    @PostMapping
    public Ticket saveTicket(@RequestBody Ticket ticket) {
        return ticketService.save(ticket);
    }

    @GetMapping("{id}")
    public List<Ticket> getUserTickets(@PathVariable("id") int idUser) {
        return ticketService.findTicketsByUser(userService.findById(idUser));
    }

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.findAll();
    }


}
