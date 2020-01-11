package nc.Medas.service;

import nc.Medas.controller.Registration;
import nc.Medas.model.Film;
import nc.Medas.repo.FilmRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {
    private final FilmRepo filmRepo;
    private final Logger LOG = LoggerFactory.getLogger(Registration.class);

    public FilmService(FilmRepo filmRepo) {
        this.filmRepo = filmRepo;
    }

    public Film save(Film film) {
        LOG.info("Film was added "+ film.getTitle());
        return filmRepo.save(film);
    }

    public void update(Film film) {
        filmRepo.update(film.getId(),film.getTitle(),film.getCountReview(),
                film.getDirector(),film.getPoster(),
                film.getProducer(),film.getDuration(),film.getRating());
    }

    public List<Film> findAll() {
        return filmRepo.findAll();
    }

    public Optional<Film> findById(int id){
       return filmRepo.findById(id);
    }

    public void deleteById(int id) {
        filmRepo.deleteById(id);
    }

    public void delete(Film film){
        filmRepo.delete(film);
    }

}
