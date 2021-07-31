package net.revature;

import net.revature.connection.DBHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static net.revature.UserMenu.menu;

public class Main {
    static private DBHandler dbHandler;
    static private Connection connection;
    static private PreparedStatement preparedStatement;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        dbHandler = new DBHandler();
        connection = dbHandler.getDBConnection();
        UserMenu menu = new UserMenu();
        menu();


        // https://jdbc.postgresql.org/download.html

	// write your code here
//        As a user, I can:
//
//        register a new user account with the system (must be secured with a password)
//        login with my existing credentials
//        create at least one account
//        deposit funds into an account (use doubles, not ints)
//        withdraw funds from an account (no overdrafting!)
//        view the balance of my account(s) (all balance displays must be in proper currency format)

//        Minimum Features
//        Basic validation (no negative deposits/withdrawals, no overdrafting, etc.)
//        All exceptions are properly caught and handled
//        Proper use of OOP principles
//        Documentation (all classes and methods have basic documentation)
//        Use of custom data structures (do not use java.util Collection types!)
//        SQL Data Persistance (at least 3 tables; all 3NF (normal form))



//        Suggested Bonus User Stories
//        As a user I can:
//
//        view the transaction history for an account
//        create multiple accounts per user (checking, savings, etc.)
//        share a joint account with another user
//        transfer money between accounts

//        Bonus Features
//        Unit tests for persistance-layer classes
//        Logging messages and exceptions to a file







//		writeToDB();
//		readFromDB();
//		updateDB("Rob","Elson", "rlejr", "1234 Parker Rd.", 2012-1962, 4 );
//		deleteUser(5);







//		String url = "jdbc:postgresql://localhost:5432/login";
//		String username = "postgres";
//		String password = "postgres";
//
//		Connection conn = DriverManager.getConnection(url, username, password);
//
//		System.out.println("Connected to Database " + conn.getCatalog());



        }

    public static void writeToDB() throws SQLException {
        String insert = "INSERT INTO users(firstname,lastname,username,address,age)"
                + "VALUES(?,?,?,?,?)";

        preparedStatement = (PreparedStatement) connection.prepareStatement(insert);

        preparedStatement.setString(1, "Shirley");
        preparedStatement.setString(2, "Elson");
        preparedStatement.setString(3, "babydafodil");
        preparedStatement.setString(4, "3630 Vance St.");
        preparedStatement.setInt(5, 2021 - 1938);
        preparedStatement.executeUpdate();
    }

    public static void readFromDB() throws SQLException {
        String query = "SELECT * FROM users";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println("Name: " + resultSet.getString("firstname") + " " + resultSet.getString("lastname"));

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
