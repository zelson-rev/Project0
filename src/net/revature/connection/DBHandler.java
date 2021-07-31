package net.revature.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler extends Config{
	
	static Connection dbConnection;
	
	public static Connection getDBConnection() throws  SQLException, ClassNotFoundException {
		
		String connectionString = "jdbc:postgresql://"+dbHost+":"+dbport+"/"+dbName;
		System.out.println("Connection String " + connectionString);
		Class.forName("org.postgresql.Driver");
		
		Connection dbConnection = DriverManager.getConnection(connectionString, dbUser, dbpassword);
		

		return dbConnection;
		
	}
	

}


//String url = "jdbc:postgresql://localhost:5432/login";
//String username = "postgres";
//String password = "postgres";
//		
//Connection conn = DriverManager.getConnection(url, username, username);
////
////System.out.println("Connected to Database " + conn.getCatalog());