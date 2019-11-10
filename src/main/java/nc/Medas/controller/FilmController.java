package nc.Medas.controller;

import nc.Medas.model.Film;
import nc.Medas.repo.FilmRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/films")
public class FilmController {

    private final FilmRepo service;

    @Autowired
    FilmController(FilmRepo service) {
        this.service = service;
    }

    @GetMapping
    public List<Film> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Film getOne(@PathVariable("id") Film film) {
        return film;
    }

    @PutMapping("{id}")
    public Film update(
            @PathVariable("id") Film filmFromDb,
            @RequestBody Film film
    ) {
        BeanUtils.copyProperties(film, filmFromDb, "id");

        return service.save(filmFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Film film) {
        service.delete(film);
    }
}


