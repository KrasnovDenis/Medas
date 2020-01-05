package nc.Medas.controller;

import nc.Medas.model.Hall;
import nc.Medas.model.Screen;
import nc.Medas.service.HallService;
import nc.Medas.service.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Hall saveHall(@RequestBody Hall hall) {
        return hallService.save(hall);
    }

    @GetMapping("/{id}")
    public Screen getHall(@PathVariable("id") int hall,
                          @RequestParam("id_screen") int screen) {


        return hallService.getHallByScreening(screenService.findById(screen));
    }




}
