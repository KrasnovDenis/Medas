package nc.Medas.service;

import com.mysql.cj.jdbc.Driver;
import nc.Medas.ModelDetails.TicketDetails;
import nc.Medas.ModelDetails.TicketEntityPrincipal;
import nc.Medas.model.User;
import org.springframework.stereotype.Service;

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
    public boolean saveTicket(TicketEntityPrincipal ticketPrincipal) throws SQLException {
        DriverManager.registerDriver(new Driver());
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            if(!hasUserEnoughMoney(ticketPrincipal)) return false;
            if (!chairIsBusy(ticketPrincipal.getChair())) {
                long userId = ticketPrincipal.getUserId();
                int screenId = ticketPrincipal.getScreenId();
                int chair = ticketPrincipal.getChair();

                boolean isInsert = statement.execute(
                        "INSERT INTO `medas`.`ticket`\n" +
                            "(`id_screen`,`id_user`,`chair`)\n" +
                        "    VALUES("+screenId +", "+ userId+", "+chair +");");

                ResultSet resultSet = statement.executeQuery(
                        "select `price` from `screen` where `id` = "+screenId);

                resultSet.next();
                int price = resultSet.getInt(resultSet.findColumn("price"));


                boolean isUpdate = statement.execute( "UPDATE `medas`.`user` set `money` = `money`-"+price+" where `id` = "+ userId);

                return !(isUpdate && isInsert);

            }
            return false;
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

    @Transactional
    public boolean chairIsBusy(int chair) throws SQLException {

        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select `chair` from `screen`, `ticket`\n " +
        "\twhere `screen`.`id` = `ticket`.`id_screen` and `chair` = "+ chair);
        List<Integer> listSeats = new ArrayList<>();
        if (resultSet.next()) {
            listSeats.add(resultSet.getInt(resultSet.findColumn("chair")));
        }

        return listSeats.contains(chair);
    }

    @Transactional
    public boolean hasUserEnoughMoney(TicketEntityPrincipal principal)throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select  `money`, `price`  from `user`, `screen`\n" +
                "\t\twhere `screen`.`id` = " + principal.getScreenId() + "\n" +
                "\t\t\tand `user`.`id` = " + principal.getUserId() + ";");

        int userMoney = 0;
        int screenPrice = 0;

        while(resultSet.next()) {
            userMoney = resultSet.getInt(resultSet.findColumn("money"));
            screenPrice = resultSet.getInt(resultSet.findColumn("price"));
        }


        return userMoney >= screenPrice;
    }

}
