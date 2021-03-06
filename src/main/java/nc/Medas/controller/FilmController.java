package nc.Medas.controller;

import nc.Medas.exception.EntityNotFoundException;
import nc.Medas.model.Film;
import nc.Medas.service.FilmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/films")
public class FilmController {


    private final FilmService filmService;


    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }


    @GetMapping
    public List<Film> list() {
        return filmService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> getOne(@PathVariable("id") int idFilm) {

        return filmService.findById(idFilm)
                .map(x -> ResponseEntity.ok(x))
                .orElseThrow(()-> new EntityNotFoundException(idFilm + " id "));
    }

    @PostMapping
    public Film save(@RequestBody Film film) {
        return filmService.save(film);
    }

    @PutMapping
    public void update(@RequestBody Film film) {
        filmService.update(film);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") int film) {
        filmService.deleteById(film);
    }


}


