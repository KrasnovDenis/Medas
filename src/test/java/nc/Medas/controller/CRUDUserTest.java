package nc.Medas.controller;

import nc.Medas.model.User;
import nc.Medas.repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
class CRUDUserTest {

    @MockBean
    private UserRepo repository;

    @Autowired
    private UserController controller;

    @Test
    void createUser() {

        User user = mock(User.class);

        controller.createUser(user);
        verify(repository, Mockito.times(1)).save(user);
    }
}