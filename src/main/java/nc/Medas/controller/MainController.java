package nc.Medas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medas")
public class MainController {
    @GetMapping
    public String list() {
        return "indeеееx";
    }
}
