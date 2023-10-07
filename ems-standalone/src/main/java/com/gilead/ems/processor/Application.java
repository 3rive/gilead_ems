package com.gilead.ems.processor;

import java.io.IOException;
import java.text.ParseException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.gilead.ems.csv.CSVProcessor;

/**
 * Hello world!
 *
 */
public class Application {
	private static final Logger logger = LogManager.getLogger(Application.class);  
	public static void main(String[] args) {
		BasicConfigurator.configure();
		String fileName ="D:\\Gilead_projects\\ems-standalone\\src\\main\\java\\com\\gilead\\ems\\processor\\Gilead_Employee_Details.csv";
		CSVProcessor csvProcessor = new CSVProcessor();
		try {
			
			logger.debug("This is a debug"); //developer
			logger.error("This is a error");		
			logger.warn("this is a warning");
			logger.info("This is a info");
			csvProcessor.getAllTrainees(fileName);
		} catch (IOException | ParseException e) {
			
			e.printStackTrace();
		}
		
		} 
	}

