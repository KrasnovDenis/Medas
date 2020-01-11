package nc.Medas.service;

import nc.Medas.controller.Registration;
import nc.Medas.model.Hall;
import nc.Medas.model.Screen;
import nc.Medas.repo.HallRepo;
import nc.Medas.repo.ScreenRepo;
import nc.Medas.repo.TicketRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HallService {
    private final HallRepo hallRepo;
    private final ScreenRepo screenRepo;
    private final TicketRepo ticketRepo;
    private final Logger LOG = LoggerFactory.getLogger(Registration.class);

    public HallService(HallRepo hallRepo, ScreenRepo screenRepo, TicketRepo ticketRepo) {
        this.hallRepo = hallRepo;
        this.screenRepo = screenRepo;
        this.ticketRepo = ticketRepo;
    }

    public Optional<Screen> getHallByScreening(Screen screen) {
        return screenRepo.findById(screen.getId());
    }

    public List<Hall> findAll() {
        return hallRepo.findAll();
    }

    public Hall save(Hall hall) {
        LOG.info("Hall was added " + hall.getTitle());
        return hallRepo.save(hall);
    }
    public Optional<Hall> findById(int id){
        return hallRepo.findById(id);
    }

    public void deleteById(int id) {
        LOG.info("Hall was deleted by ID " + id);
        hallRepo.deleteById(id);
    }

    public void delete(Hall hall){
        LOG.info("Hall was deleted " + hall.getTitle());
        hallRepo.delete(hall);
    }



}
