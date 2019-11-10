package nc.Medas.repo;

import nc.Medas.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  FilmRepo extends JpaRepository<Film, Integer> {
}
