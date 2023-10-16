/**
 * 
 */
package com.gilead.ems.validation;

import java.io.File;
import java.sql.Connection;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


/**
 * 
 */
public class EmsValidator {

	final Logger log = LogManager.getLogger(EmsValidator.class);
	public boolean check(Connection connection, String csvfilePath) {
		if(connection ==null) {
			log.error("Database connection is down");
		}
		File file = new File(csvfilePath);
		if(!file.exists()) {
			log.error("CSV file is not available in the location : "+csvfilePath);
		}
		if(connection != null && file.exists()) {
			return true;
		}
		return false;	
	}

}
