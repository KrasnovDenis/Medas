package nc.Medas.service;

import nc.Medas.model.Hall;
import nc.Medas.model.Screen;
import nc.Medas.repo.HallRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class HallService {
    private HallRepo hallRepo;

    public HallService(HallRepo hallRepo) {
        this.hallRepo = hallRepo;
    }

    //упорото, зато работает
    public Hall getHallByScreening(Screen screen) throws SQLException {
        return hallRepo.findById(screen.getHall().getId()).get();
    }
}
