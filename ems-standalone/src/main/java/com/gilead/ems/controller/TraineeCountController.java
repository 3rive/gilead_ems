/**
 * 
 */
package com.gilead.ems.controller;

import java.sql.Connection;

import com.gilead.ems.service.TraineeService;

/**
 * 
 */
public class TraineeCountController {
	public void count(Connection connection, String csvfilePath) {
		TraineeService service = new TraineeService();
		service.countTrainees(connection,csvfilePath);
	}
}
