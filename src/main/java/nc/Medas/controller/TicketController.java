package nc.Medas.controller;

import nc.Medas.model.User;
import nc.Medas.ModelDetails.TicketDetails;
import nc.Medas.ModelDetails.TicketEntityPrincipal;
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


    @PostMapping
    public boolean saveTicket( @RequestBody TicketEntityPrincipal ticketEntityPrincipal) throws SQLException {

        return ticketService.saveTicket( ticketEntityPrincipal);
    }

    @GetMapping("{id}")
    public List<TicketDetails> getTicket(@PathVariable("id") User user) throws SQLException {
        return ticketService.getTickets(user);
    }



}
