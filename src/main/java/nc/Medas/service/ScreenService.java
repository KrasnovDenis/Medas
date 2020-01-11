package nc.Medas.service;

import nc.Medas.controller.Registration;
import nc.Medas.model.Screen;
import nc.Medas.repo.ScreenRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScreenService {

    private final ScreenRepo screenRepo;
    private final Logger LOG = LoggerFactory.getLogger(Registration.class);


    public ScreenService(ScreenRepo screenRepo) {
        this.screenRepo = screenRepo;
    }

    public List<Screen> findAll() {
        return screenRepo.findAll();
    }

    public Optional<Screen> findById(int id){

        return screenRepo.findById(id);
    }

    public void deleteById(int id) {
        LOG.info("Screen was deleted by id " + id);
        screenRepo.deleteById(id);
    }

    public void delete(Screen screen){

        LOG.info("Screen was deleted " + screen.getFilm());
        screenRepo.delete(screen);
    }

    public Screen save (Screen screen)
    {
        LOG.info("Screen was added " + screen.getFilm());
        return screenRepo.save(screen);
    }

}
