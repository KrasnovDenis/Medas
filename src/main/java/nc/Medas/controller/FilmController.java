package nc.Medas.controller;

import nc.Medas.model.Film;
import nc.Medas.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/films")
public class FilmController {


    @Autowired
    private FilmService service = new FilmService();

    @GetMapping
    public List<Film> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Film getFilmById(@PathVariable String id)  {
        return service.findFilmById(Integer.parseInt(id));
    }


    @PostMapping
    public void createUser(Film film) {
        service.save(film);
    }
}
