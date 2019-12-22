package nc.Medas.repo;

import nc.Medas.model.Hall;
import nc.Medas.model.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallRepo extends JpaRepository<Hall,Integer> {
}
