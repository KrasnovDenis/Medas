package nc.Medas.repo;

import nc.Medas.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface  FilmRepo extends JpaRepository<Film, Integer> {

    @Transactional
    @Modifying
    @Query("update Film film set film.title=?2, film.countReview=?3, film.director=?4, film.poster=?5, film.producer=?6, film.duration=?7, film.rating=?8 where film.id=?1")
    void update(int id,String title, int countReview, String director, String poster, String producer, short duration, double rating );
}
