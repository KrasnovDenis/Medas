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
public class FilmTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void badCredential() throws Exception {
        mockMvc.perform(get("/films").param("Authorization", "Fake password"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void permissionDenied() throws Exception { //Adds films by users is not allowed
        String json = "{\n" +
                "            \n" +
                "            \"duration\": 112,\n" +
                "            \"title\": \"Скорый Москва-Россия\",\n" +
                "            \"poster\": \"../images/film6.jpg\",\n" +
                "            \"rating\": 2.8,\n" +
                "            \"director\": \"Георгий Крыжовников\",\n" +
                "            \"producer\": \" Сергей Светлаков\",\n" +
                "            \"countReview\": 46\n" +
                "        }";


        mockMvc.perform(post("/films")
                .header("Authorization", "Basic Q3liZXJQdW5rOjEyM3F3ZWFzZA==")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    public void addFilm() throws Exception {
        String json = "{\n" +
                "            \n" +
                "            \"duration\": 112,\n" +
                "            \"title\": \"Скорый Москва-Россия\",\n" +
                "            \"poster\": \"../images/film6.jpg\",\n" +
                "            \"rating\": 2.8,\n" +
                "            \"director\": \"Георгий Крыжовников\",\n" +
                "            \"producer\": \" Сергей Светлаков\",\n" +
                "            \"countReview\": 46\n" +
                "        }";

        mockMvc.perform(post("/films")
                .header("Authorization", "Basic RHVkZTczOjEyM3F3ZWFzZA==")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
