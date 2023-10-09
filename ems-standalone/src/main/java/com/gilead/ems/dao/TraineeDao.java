package com.gilead.ems.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.gilead.ems.model.Trainee;

public class TraineeDao {

	public String saveToDB(Trainee trainee) {
		final Logger log = LogManager.getLogger(TraineeDao.class);
		Connection connection = null;
		String name = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "Letmein@123");
			if (connection != null) {
				Statement statement;
				statement = connection.createStatement();
				Date dobSql = new Date(trainee.getDob().getTime());
				Date dojSql = new Date(trainee.getDoj().getTime());
				statement.executeUpdate("INSERT INTO sakila.Trainee " + "VALUES (" + "'" + trainee.getId() + "'" + ","
						+ "'" + trainee.getCompany() + "'" + "," + "'" + trainee.getName() + "'" + "," + "'"
						+ dobSql + "'" + "," + "'" + trainee.getGender() + "'" + "," + "'" + dojSql
						+ "'" + "," + "'" + trainee.getRole() + "'" + ")");
				name = trainee.getName();

			} else {
				log.error("Connection Object is NULL");
			}
		} catch (Exception exception) {
			log.error("Error occurred while saving to database " + exception.toString());
		}
		return name;

	}

}
