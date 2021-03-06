package nc.Medas.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LoginUserTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getOnLogin() throws Exception { //get mapping not supported to Login
        mockMvc.perform(get("/login"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    @Test
    public void badCreds()throws Exception {
        String jsonLoginModel = "{\n" +
                "\t\"username\":\"FakeUsername\",\n" +
                "\t\"password\":\"FakePassword\"\n" +
                "}\n";

        mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonLoginModel))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void successfulLogin()throws Exception {
        String jsonLoginModel = "{\n" +
                "\t\"username\":\"Batr\",\n" +
                "\t\"password\":\"123qweasd\"\n" +
                "}\n";

        mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonLoginModel))
                .andDo(print())
                .andExpect(status().isOk());

    }




}
