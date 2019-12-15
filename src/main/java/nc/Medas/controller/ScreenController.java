package nc.Medas.controller;

import nc.Medas.ModelDetails.ScheduleDetails;
import nc.Medas.model.Screen;
import nc.Medas.repo.ScreenRepo;
import nc.Medas.service.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/screen")
public class ScreenController {

    @Autowired
    private ScreenService screenService;

    @Autowired
    private ScreenRepo screenRepo;


    @GetMapping
    public List<ScheduleDetails> getAllScreens() throws SQLException {
        return screenService.getAllScreens();
    }

    @PostMapping
    public Screen addScreen(@RequestBody Screen screen) {
        return screenRepo.save(screen);
    }


}
