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
public class ScreenTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void badCredential() throws Exception {
        mockMvc.perform(get("/screen").param("Authorization", "Fake password"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void permissionDenied() throws Exception {// Adds screen by user is not allowed

        String json = "{\n" +
                "        \"hall\": {\n" +
                "            \"id\": 1,\n" +
                "            \"title\": \"Большой зал\",\n" +
                "            \"capacity\": 50\n" +
                "        },\n" +
                "        \"film\": {\n" +
                "            \"id\": 6,\n" +
                "            \"duration\": 112,\n" +
                "            \"title\": \"Скорый Москва-Россия\",\n" +
                "            \"poster\": \"../images/film6.jpg\",\n" +
                "            \"rating\": 2.8,\n" +
                "            \"director\": \"Георгий Крыжовников\",\n" +
                "            \"producer\": \" Сергей Светлаков\",\n" +
                "            \"countReview\": 46\n" +
                "        },\n" +
                "        \"dateTime\": \"2019-12-12T08:00:00.000+0000\",\n" +
                "        \"price\": 200.0\n" +
                "    }";

        mockMvc.perform(post("/screen")
                .header("Authorization", "Basic Q3liZXJQdW5rOjEyM3F3ZWFzZA==")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    public void addScreen() throws Exception {

        String json = "{\n" +
                "        \"hall\": {\n" +
                "            \"id\": 1,\n" +
                "            \"title\": \"Большой зал\",\n" +
                "            \"capacity\": 50\n" +
                "        },\n" +
                "        \"film\": {\n" +
                "            \"id\": 6,\n" +
                "            \"duration\": 112,\n" +
                "            \"title\": \"Скорый Москва-Россия\",\n" +
                "            \"poster\": \"../images/film6.jpg\",\n" +
                "            \"rating\": 2.8,\n" +
                "            \"director\": \"Георгий Крыжовников\",\n" +
                "            \"producer\": \" Сергей Светлаков\",\n" +
                "            \"countReview\": 46\n" +
                "        },\n" +
                "        \"dateTime\": \"2019-12-12T08:00:00.000+0000\",\n" +
                "        \"price\": 200.0\n" +
                "    }";

        mockMvc.perform(post("/screen")
                .header("Authorization", "Basic RHVkZTczOjEyM3F3ZWFzZA==")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
