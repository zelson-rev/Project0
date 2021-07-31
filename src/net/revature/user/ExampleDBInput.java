package net.revature.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExampleDBInput {
    static private Connection connection;
    static private PreparedStatement preparedStatement;

    public static void writeToDB() throws SQLException {
        String insert = "INSERT INTO users(firstname,lastname,username,address,age)"
                + "VALUES(?,?,?,?,?)";

        preparedStatement = (PreparedStatement) connection.prepareStatement(insert);

        preparedStatement.setString(1, "Joey");
        preparedStatement.setString(2, "Slips");
        preparedStatement.setString(3, "jslip");
        preparedStatement.setString(4, "3630 main St.");
        preparedStatement.setInt(5, 38);
        preparedStatement.executeUpdate();
    }

    public static void readFromDB() throws SQLException{
        String query = "SELECT * FROM users";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            System.out.println("Name: " + ((ResultSet) resultSet).getString("firstname") + " " + resultSet.getString("lastname"));

        }


    }

    public static void updateDB(String firstname, String lastname, String username, String address, int age, int id ) {

        String query = "UPDATE users SET firstname = ?, lastname = ?, username = ?, address = ?, age = ?" + "WHERE userid = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, username);
            preparedStatement.setString(4, address);
            preparedStatement.setInt(5, age);
            preparedStatement.setInt(6, id);

            preparedStatement.executeUpdate();
            preparedStatement.close();





        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void deleteUser(int id) {
        String query = "DELETE FROM users WHERE userid = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, id);

            preparedStatement.execute();
            preparedStatement.close();





        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
