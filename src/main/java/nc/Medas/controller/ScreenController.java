package nc.Medas.controller;

import nc.Medas.service.Schedule;
import nc.Medas.service.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/screen")
public class ScreenController {
    @Autowired
    private ScreenService screenService;


    @GetMapping
    public List<Schedule> getAllScreens() throws SQLException {
        return screenService.getAllScreens();
    }


}
