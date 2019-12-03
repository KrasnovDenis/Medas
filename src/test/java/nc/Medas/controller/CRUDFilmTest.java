package nc.Medas.controller;

import nc.Medas.model.Film;
import nc.Medas.repo.FilmRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CRUDFilmTest {

    @Autowired
    FilmController controller;

    @MockBean
    FilmRepo repository;

    @Test
    public void addFilmTest() {

        Film film = mock(Film.class);

        controller.save(film);

        verify(repository, Mockito.times(1)).save(film);

    }

    @Test
    public void deleteFilmTest() {
        Film film = mock(Film.class);
        controller.delete(film);

        verify(repository, Mockito.times(1)).delete(film);

    }

    @Test
    public void getFilmTest() {

        controller.getOne(1);

        verify(repository, Mockito.times(1)).getOne(1);

    }

    @Test
    public void updateFilmTest() {


        Film filmOld = mock(Film.class);
        Film filmNew = mock(Film.class);


        controller.update(filmOld, filmNew);

        verify(repository, Mockito.times(1)).save(filmNew);

    }

}
