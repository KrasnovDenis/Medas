package nc.Medas.controller;

import nc.Medas.model.Hall;
import nc.Medas.repo.ScreenRepo;
import nc.Medas.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/halls")
public class HallController  {

    private HallService service;
    private ScreenRepo screenRepo;

    @Autowired
    HallController(HallService service, ScreenRepo screenRepo) {
        this.screenRepo = screenRepo;
        this.service = service;
    }

    @GetMapping("/{id}")
    public Hall getHall(@PathVariable("id") int hall,
                               @RequestParam("id_screen") int screen) throws SQLException {


        return service.getHallByScreening(screenRepo.findById(screen).get());
    }





}
