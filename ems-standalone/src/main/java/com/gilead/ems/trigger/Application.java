package com.gilead.ems.trigger;

import java.sql.Connection;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.gilead.ems.connection.DBConnection;
import com.gilead.ems.controller.TraineeDeleteController;
import com.gilead.ems.controller.TraineeInsertController;
import com.gilead.ems.controller.TraineeReadController;
import com.gilead.ems.controller.TraineeUpdateController;
import com.gilead.ems.model.Trainee;

/**
 * Main class that triggers the trainee data uploading functionality
 *
 */
public class Application {
	private static final Logger logger = LogManager.getLogger(Application.class);

	public static void main(String[] args) {
		BasicConfigurator.configure();
		String fileName = args[0];
		String operation = args[1];
		String traineeId = null;
		if(operation.equals("update")) {
			traineeId = args[2];
		}		
		Connection connection = DBConnection.getConnection("jdbc:mysql://localhost:3306/ems", "root", "Letmein@123");
		switch (operation) {
		//C
		case "insert": {
			TraineeInsertController insertController = new TraineeInsertController();
			logger.info("Inserting the trainee information to the database");
			insertController.save(fileName, connection);
			break;
		}
		//R
		case "read": {
			TraineeReadController readController = new TraineeReadController();
			logger.info("Reading the trainee information from database");
			readController.read(connection);
			break;
		}
		//U
		case "update": {
			TraineeUpdateController updateController = new TraineeUpdateController();
			logger.info("Updating the trainee information in database");
			Trainee trainee = new Trainee();
			trainee.setId(Integer.parseInt(traineeId));
			trainee.setCompany("Gilead Hi-Tech");
			updateController.update(connection, trainee);
			break;
		}
		//D
		case "delete": {
			TraineeDeleteController deleteController = new TraineeDeleteController();
			logger.info("Deleting the trainee information from database");
			deleteController.delete(connection);
			break;
		}
		default:
			logger.error("The operation "+ operation+ "cannot be performed");
		}
	}
}
