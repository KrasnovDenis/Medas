package nc.Medas.controller;

import nc.Medas.ModelDetails.HallDetails;
import nc.Medas.model.Hall;
import nc.Medas.model.Screen;
import nc.Medas.repo.FilmRepo;
import nc.Medas.repo.HallRepo;
import nc.Medas.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/halls")
public class HallController  {

    private HallService service;

    @Autowired
    HallController(HallService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public HallDetails getHall(@PathVariable("id") int hall,
                               @RequestParam("id_screen") int screen) throws SQLException {

        return service.getHallByScreening(hall,screen);
    }





}
