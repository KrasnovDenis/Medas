package nc.Medas.controller;

import nc.Medas.exception.EntityNotFoundException;
import nc.Medas.model.Ticket;
import nc.Medas.service.ScreenService;
import nc.Medas.service.TicketService;
import nc.Medas.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tickets")
@RestController
public class TicketController {


    private final TicketService ticketService;
    private final UserService userService;
    private final ScreenService screenService;


    public TicketController(TicketService ticketService, UserService userService,ScreenService screenService) {
        this.ticketService = ticketService;
        this.userService = userService;
        this.screenService = screenService;
    }

    @PostMapping
    public Ticket saveTicket(@RequestBody Ticket ticket) {
        return ticketService.save(ticket);
    }

    @GetMapping("{id}")
    public List<Ticket> getUserTickets(@PathVariable("id") long idUser) {
        return ticketService.findTicketsByUser(userService.findById(idUser).orElseThrow(()->new EntityNotFoundException(idUser + " id ")));
    }

    @GetMapping
    public List<Ticket> getBusySeats(
            @RequestParam("id_screen") int screen) {
        return ticketService.getBusySeats(screenService.findById(screen).orElseThrow(()-> new EntityNotFoundException(screen +  " id")));
    }

}
