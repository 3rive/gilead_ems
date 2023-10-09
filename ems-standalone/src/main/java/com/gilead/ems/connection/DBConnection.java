package com.gilead.ems.connection;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DBConnection {
	
	public static Connection getConnection(String dbUrl, String userName, String password) {
		final Logger log = LogManager.getLogger(DBConnection.class);
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "Letmein@123");
		}
		 catch (Exception exception) {
				log.error("Error occurred while saving to database " + exception.toString());
			}
		return connection;
	}

}