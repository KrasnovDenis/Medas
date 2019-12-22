package nc.Medas.service;

import nc.Medas.model.Screen;
import nc.Medas.repo.ScreenRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreenService {

    private ScreenRepo screenRepo;

    public ScreenService(ScreenRepo screenRepo) {
        this.screenRepo = screenRepo;
    }
    public List<Screen> getAllScreens(){
        return screenRepo.findAll();
    }





}
