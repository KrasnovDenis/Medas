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
public class TicketsTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void badCredential() throws Exception {
        mockMvc.perform(get("/tickets").param("Authorization", "Fake password"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void buyTicket() throws Exception {

        String json = "{\n" +
                "\t\"user\" : {\n" +
                "    \"id\": 1,\n" +
                "    \"firstName\": \"Олег\",\n" +
                "    \"lastName\": \"Панкин\",\n" +
                "    \"birthDate\": \"1970-12-12\",\n" +
                "    \"telephone\": \"+7954646352\",\n" +
                "    \"password\": \"$2a$10$4YDN34gihI6ItV585vXpwuiwbfpRtC07CrQ2go35zYdqusLQ2IxtC\",\n" +
                "    \"login\": \"CyberPunk\",\n" +
                "    \"role\": \"USER\",\n" +
                "    \"money\": 1500.0,\n" +
                "    \"email\": \"Elo.1972@yandex.ru\"\n" +
                "},\n" +
                "\t\"screen\" : {\n" +
                "        \"id\": 1,\n" +
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
                "    } ,\n" +
                "\t\"chair\" : 11\n" +
                "\t\n" +
                "}";

        mockMvc.perform(post("/tickets")
                .header("Authorization", "Basic RHVkZTczOjEyM3F3ZWFzZA==")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
