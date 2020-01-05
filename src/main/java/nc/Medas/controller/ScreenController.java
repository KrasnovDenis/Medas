package nc.Medas.controller;

import nc.Medas.model.Screen;
import nc.Medas.service.ScreenService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/screen")
public class ScreenController {


    private final ScreenService screenService;

    public ScreenController(ScreenService screenService) {
        this.screenService = screenService;
    }


    @GetMapping
    public List<Screen> getAllScreens()  {
        return screenService.findAll();
    }

    @PostMapping
    public Screen addScreen(@RequestBody Screen screen) {
        return screenService.save(screen);
    }


    @GetMapping("{id}")
    public Screen getOne(@PathVariable("id") int id) {
        return screenService.findById(id);
    }

}
