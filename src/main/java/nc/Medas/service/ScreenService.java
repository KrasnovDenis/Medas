package nc.Medas.service;

import nc.Medas.repo.FilmRepo;
import nc.Medas.repo.HallRepo;
import nc.Medas.repo.ScreenRepo;
import org.hibernate.dialect.MySQL8Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScreenService {

    String url = "jdbc:mysql://localhost:3306/medas?serverTimezone=Europe/Saratov";
    String username = "root";
    String password = "woofwoof";


    public List<Schedule> getAllScreens() throws SQLException {
        List<Schedule> listSchedule = new ArrayList<>();
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
                    "        `medas`.`screen`.price as `ScreenPrice`\n" +
                    "        from `medas`.`film` , `medas`.`hall`,`medas`.`screen`\n" +
                    "        where `medas`.`film`.id = `medas`.`screen`.id_film and `medas`.`hall`.id = `medas`.`screen`.id_hall");


            while (resultSet.next()) {

                listSchedule.add(new Schedule.ScheduleBuilder()
                        .setFilmTitle(resultSet.getString(resultSet.findColumn("FilmTitle")))
                        .setFilmDuration(resultSet.getDouble(resultSet.findColumn("FilmDuration")))
                        .setFilmPoster(resultSet.getString(resultSet.findColumn("FilmPoster")))
                        .setFilmRating(resultSet.getDouble(resultSet.findColumn("FilmRating")))
                        .setHallTitle(resultSet.getString(resultSet.findColumn("HallTitle")))
                        .setScreenDateTime(resultSet.getString(resultSet.findColumn("ScreenDateTime")))
                        .setScreenPrice(resultSet.getInt(resultSet.findColumn("ScreenPrice")))
                        .build()
                );



            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return listSchedule;

    }
}
