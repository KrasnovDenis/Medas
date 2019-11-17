package nc.Medas.controller;

import nc.Medas.model.Film;
import nc.Medas.repo.FilmRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/films")
public class FilmController {


    private final FilmRepo repository;

    @Autowired
    FilmController(FilmRepo repository) {
        this.repository = repository;
    }


    @GetMapping
    public List<Film> list() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Film getOne(@PathVariable("id") Film film) {
        return film;
    }

    @PostMapping
    public Film save(@RequestBody Film film){
        return repository.save(film);
    }

    @PutMapping("{id}")
    public Film update(
            @PathVariable("id") Film filmFromDb,
            @RequestBody Film film
    ) {
        BeanUtils.copyProperties(film, filmFromDb, "id");

        return repository.save(filmFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Film film) {
        repository.delete(film);
    }
}


