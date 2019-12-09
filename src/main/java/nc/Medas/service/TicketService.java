package nc.Medas.service;

import com.mysql.cj.jdbc.Driver;
import nc.Medas.model.Screen;
import nc.Medas.model.Ticket;
import nc.Medas.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import javax.transaction.NotSupportedException;
import javax.transaction.Transactional;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    private String url = "jdbc:mysql://localhost:3306/medas?serverTimezone=Europe/Saratov";
    private String username = "root";
    private String password = "woofwoof";

    @Transactional
    public boolean saveTicket(User user, TicketEntityPrincipal ticketPrincipal) throws SQLException {
        DriverManager.registerDriver(new Driver());
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();

            if (checkChair(ticketPrincipal.getChair())) {
                long userId = ticketPrincipal.getUserId();
                int screenId = ticketPrincipal.getScreenId();
                int chair = ticketPrincipal.getChair();

//                statement.execute("insert INSERT INTO " +
//                        "`medas`.`ticket`\n" +
//                        "(`id_screen`,`id_user`,`chair`)\n" +
//                        "VALUES(" + screenId + ", " + userId + "," + chair + ");");

                boolean isSuccess = statement.execute("insert INSERT INTO " +
                        "`medas`.`ticket`\n" +
                        "(`id_screen`,`id_user`,`chair`)\n" +
                        "VALUES(" + screenId + ", " + userId + "," + chair + ");");

                return isSuccess;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;

    }

    @Transactional
    public List<TicketDetails> getTickets(User user) throws SQLException {
        DriverManager.registerDriver(new Driver());
        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            Statement statement = connection.createStatement();


            long userId = user.getId();

            ResultSet resultSet = statement.executeQuery("select `medas`.`hall`.title as `TitleHall`,\n" +
                    "\t\t`medas`.`user`.first_name as `FirstName`,\n" +
                    "\t\t`medas`.`user`.last_name as `LastName`,\n" +
                    "\t\t`medas`.`screen`.price as `Price`,\n" +
                    "        `medas`.`screen`.date_time as `DateScreen`,\n" +
                    "        `medas`.`film`.title as `TitleFilm`,\n" +
                    "        `medas`.`ticket`.chair as `Chair`\n" +
                    " from `medas`.`ticket`, `medas`.`screen`, `medas`.`hall`, `medas`.`user`,`medas`.`film`\n" +
                    "\t\twhere `medas`.`ticket`.id_screen = `medas`.`screen`.id and\n" +
                    "\t\t\t\t`medas`.`ticket`.id_user = `medas`.`user`.id and\n" +
                    "\t\t\t\t`medas`.`screen`.id_film = `medas`.`film`.id and\n" +
                    "\t\t\t\t`medas`.`screen`.id_hall = `medas`.`hall`.id and\n" +
                    "\t\t\t\t`medas`.`ticket`.id_user = " + userId + ";");

            List<TicketDetails> listTickets = new ArrayList<>();
            while (resultSet.next()) {
                listTickets.add(new TicketDetails.TicketDetailsBuilder()
                        .setFilm(resultSet.getString(resultSet.findColumn("TitleFilm")))
                        .setFirstName(resultSet.getString(resultSet.findColumn("FirstName")))
                        .setLastName(resultSet.getString(resultSet.findColumn("LastName")))
                        .setHallName(resultSet.getString(resultSet.findColumn("TitleHall")))
                        .setPrice(resultSet.getInt(resultSet.findColumn("Price")))
                        .setChair(resultSet.getInt(resultSet.findColumn("Chair")))
                        .setDateScreen(resultSet.getDate(resultSet.findColumn("DateScreen")))
                        .build());
            }
            return listTickets;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    private boolean checkChair(int chair) throws SQLException {

        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        return true;
    }
}
