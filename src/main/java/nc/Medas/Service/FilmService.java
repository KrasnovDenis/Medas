package nc.Medas.service;

import nc.Medas.model.Film;
import org.springframework.stereotype.Service;
import nc.Medas.dao.FilmDAO;

import java.util.List;

@Service
public class FilmService {
    private FilmDAO filmDAO = new FilmDAO();

    public void save(Film film) {
        filmDAO.save(film);
    }

    public void update(Film film) {
        filmDAO.update(film);
    }

    public Film findFilmById(int id) {
        return filmDAO.findById(id);
    }

    public void delete(Film film) {
        filmDAO.delete(film);
    }

    public List<Film> findAll() {
        return filmDAO.findAll();
    }

}
