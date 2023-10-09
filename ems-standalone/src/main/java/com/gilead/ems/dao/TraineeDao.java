package com.gilead.ems.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.gilead.ems.model.Trainee;

public class TraineeDao {

	final Logger log = LogManager.getLogger(TraineeDao.class);
	public String saveToDB(Connection connection, Trainee trainee) {

		String name = null;
		try {
				Statement statement;
				statement = connection.createStatement();
				Date dobSql = new Date(trainee.getDob().getTime());
				Date dojSql = new Date(trainee.getDoj().getTime());
				statement.executeUpdate("INSERT INTO sakila.Trainee " + "VALUES (" + "'" + trainee.getId() + "'" + ","
						+ "'" + trainee.getCompany() + "'" + "," + "'" + trainee.getName() + "'" + "," + "'"
						+ dobSql + "'" + "," + "'" + trainee.getGender() + "'" + "," + "'" + dojSql
						+ "'" + "," + "'" + trainee.getRole() + "'" + ")");
				name = trainee.getName();

		} catch (Exception exception) {
			log.error("Error occurred while saving to database " + exception.toString());
		}
		return name;
	}
	
	public List<Trainee> readFromDB(Connection connection) {
		List<Trainee> trainees = new ArrayList<Trainee>();
		try {
				Statement statement;
				statement = connection.createStatement();
				ResultSet rs =  statement.executeQuery("SELECT * from sakila.trainee");
				Trainee trainee = new Trainee();
				 if (rs != null) {
	                    while (rs.next()) {
	                    	trainee.setId(rs.getInt("id"));
	                    	trainee.setName(rs.getString("name"));
	                    	trainees.add(trainee);
	                    }
	                }

		} catch (Exception exception) {
			log.error("Error occurred while saving to database " + exception.toString());
		}
		return trainees;
	}

}
