package it.polito.tdp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	public static Connection getConnection() throws SQLException{
		String jdbc = "jdbc:mysql://localhost/dizionario?user=root&password=root";
		return DriverManager.getConnection(jdbc);
	}
}
