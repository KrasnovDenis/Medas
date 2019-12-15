package nc.Medas.service;

import nc.Medas.ModelDetails.ScheduleDetails;
import org.springframework.stereotype.Service;
import com.mysql.cj.jdbc.Driver;

import javax.transaction.Transactional;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScreenService {

    String url = "jdbc:mysql://localhost:3306/medas?serverTimezone=Europe/Saratov";
    String username = "root";
    String password = "woofwoof";


    public List<ScheduleDetails> getAllScreens() throws SQLException {
        List<ScheduleDetails> listScheduleDetails = new ArrayList<>();
        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("Select `medas`.`film`.title as `FilmTitle`,\n" +
                    "\t\t`medas`.`film`.duration as `FilmDuration`,\n" +
                    "        `medas`.`film`.poster as `FilmPoster`,\n" +
                    "        `medas`.`film`.rating as `FilmRating`,\n" +
                    "        `medas`.`hall`.title as `HallTitle`,\n" +
                    "        `medas`.`screen`.date_time as `ScreenDateTime`,\n" +
                    "        `medas`.`screen`.price as `ScreenPrice`,\n" +
                    "        `medas`.`screen`.id as `id_screen`,\n" +
                    "        `medas`.`screen`.id_hall as `id_hall`\n" +
                    "        \n" +
                    "        from `medas`.`film` , `medas`.`hall`,`medas`.`screen`\n" +
                    "        where `medas`.`film`.id = `medas`.`screen`.id_film and `medas`.`hall`.id = `medas`.`screen`.id_hall \n" +
                    "       ");


            while (resultSet.next()) {

                listScheduleDetails.add(new ScheduleDetails.ScheduleBuilder()
                        .setFilmTitle(resultSet.getString(resultSet.findColumn("FilmTitle")))
                        .setFilmDuration(resultSet.getDouble(resultSet.findColumn("FilmDuration")))
                        .setFilmPoster(resultSet.getString(resultSet.findColumn("FilmPoster")))
                        .setFilmRating(resultSet.getDouble(resultSet.findColumn("FilmRating")))
                        .setHallTitle(resultSet.getString(resultSet.findColumn("HallTitle")))
                        .setScreenDateTime(resultSet.getString(resultSet.findColumn("ScreenDateTime")))
                        .setScreenPrice(resultSet.getInt(resultSet.findColumn("ScreenPrice")))
                        .setIdHall(resultSet.getInt(resultSet.findColumn("id_hall")))
                        .setIdScreen(resultSet.getInt(resultSet.findColumn("id_screen")))
                        .build()
                );



            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return listScheduleDetails;

    }



}
