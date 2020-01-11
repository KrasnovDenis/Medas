package nc.Medas.controller;

import nc.Medas.exception.EntityNotFoundException;
import nc.Medas.model.Hall;
import nc.Medas.model.Screen;
import nc.Medas.service.HallService;
import nc.Medas.service.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/halls")
public class HallController {

    private final HallService hallService;
    private final ScreenService screenService;

    @Autowired
    public HallController(HallService service, ScreenService screenService) {
        this.screenService = screenService;
        this.hallService = service;
    }

    @PostMapping
    public Hall saveHall(@RequestBody Hall hall) {
        return hallService.save(hall);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Screen> getHall(@PathVariable("id") int hall,
                                          @RequestParam("id_screen") int screen) {


        return hallService.getHallByScreening(screenService.findById(screen).orElseThrow(() -> new EntityNotFoundException(screen + " id")))
                .map((x) -> ResponseEntity.ok(x))
                .orElseThrow(() -> new EntityNotFoundException(screen + " ID"));
    }


}
