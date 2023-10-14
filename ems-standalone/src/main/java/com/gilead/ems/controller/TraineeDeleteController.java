/**
 * 
 */
package com.gilead.ems.controller;

import java.sql.Connection;

import com.gilead.ems.service.TraineeService;

/**
 * 
 */
public class TraineeDeleteController {

	public void clear(Connection connection) {
		TraineeService service = new TraineeService();
		service.deleteTrainees(connection);
	}

	public void delete(Connection connection, String traineeId) {
		// TODO Auto-generated method stub
		
	}

}
