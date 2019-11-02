package nc.Medas.controller;

import nc.Medas.Exceptions.FilmNotFoundException;
import nc.Medas.Exceptions.IdNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class MainController {
    private List<Map<String, String>> list = new ArrayList<Map<String, String>>() {{
        add(new HashMap<String, String>() {{
            put("id", "1");
            put("film", "Titanic");
        }});
        add(new HashMap<String, String>() {{
            put("id", "2");
            put("film", "Red");
        }});
        add(new HashMap<String, String>() {{
            put("id", "3");
            put("film", "1408");
        }});
    }};

    @GetMapping
    public List<Map<String, String>> list() {
        return list;
    }

    @GetMapping("{id}")
    public Map<String, String> getFilmById(@PathVariable String id) throws IdNotFoundException {
        return list.stream().
                filter(list -> list.get("id").
                        equals(id)).
                findFirst().orElseThrow(IdNotFoundException::new);
    }

    @GetMapping("{film}")
    public Map<String, String> getFilm (@PathVariable String film) throws FilmNotFoundException {
        return list.stream().
                filter(list -> list.get("film").
                        equals(film)).
                findFirst().orElseThrow(FilmNotFoundException::new);
    }




}
