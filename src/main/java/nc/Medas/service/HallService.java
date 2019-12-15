package nc.Medas.service;

import com.mysql.cj.jdbc.Driver;
import nc.Medas.ModelDetails.HallDetails;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class HallService {

    private String url = "jdbc:mysql://localhost:3306/medas?serverTimezone=Europe/Saratov";
    private String username = "root";
    private String password = "woofwoof";

    @Transactional
    public HallDetails getHallByScreening(int idHall, int idScreening) throws SQLException {
        DriverManager.registerDriver(new Driver());
        HallDetails hallDetails = null;

        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select `title`, `capacity` , `date_time`, `chair` from `medas`.`hall`,`medas`.`screen`,`medas`.`ticket` \t\n" +
                    "\t\t\twhere `medas`.`hall`.`id` = `medas`.`screen`.`id_hall`" +
                    "                    and `hall`.`id` =" + idHall +
                    "                    and `screen`.`id` = " + idScreening + ";");


            List<Integer> listSeats = new ArrayList<>();

            while (resultSet.next()) {

                listSeats.add(resultSet.getInt(resultSet.findColumn("chair")));

            }
            if (resultSet.previous()) {

                hallDetails = new HallDetails.HallDetailsBuilder()
                        .setTitle(resultSet.getString(resultSet.findColumn("title")))
                        .setDateTime(resultSet.getDate(resultSet.findColumn("date_time")))
                        .setCapacity(resultSet.getInt(resultSet.findColumn("capacity")))
                        .setBusySeats(listSeats)
                        .build();
                // код загрязнен потому что в выобрке
                //  нам нужны по сути места, которые передаются как массив
                //   остальные поля просто дублируются в выборке

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hallDetails;

    }
}
