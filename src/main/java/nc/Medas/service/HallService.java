package nc.Medas.service;

import nc.Medas.controller.Registration;
import nc.Medas.model.Hall;
import nc.Medas.model.Hall;
import nc.Medas.model.Screen;
import nc.Medas.repo.HallRepo;
import nc.Medas.repo.ScreenRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallService {
    private final HallRepo hallRepo;
    private final ScreenRepo screenRepo;
    private final Logger LOG = LoggerFactory.getLogger(Registration.class);

    public HallService(HallRepo hallRepo, ScreenRepo screenRepo) {
        this.hallRepo = hallRepo;
        this.screenRepo = screenRepo;
    }

    public Screen getHallByScreening(Screen screen) {
        return screenRepo.findById(screen.getId()).orElse(new Screen());
    }

    public List<Hall> findAll() {
        return hallRepo.findAll();
    }

    public Hall save(Hall hall) {
        LOG.info("был добавлен зал " + hall.getTitle());
        return hallRepo.save(hall);
    }
    public Hall findById(int id){
        return hallRepo.findById(id).orElse(new Hall());
    }

    public void deleteById(int id) {
        LOG.info("был удален зал по ID " + id);
        hallRepo.deleteById(id);
    }

    public void delete(Hall hall){
        LOG.info("был удален зал " + hall.getTitle());
        hallRepo.delete(hall);
    }

}
