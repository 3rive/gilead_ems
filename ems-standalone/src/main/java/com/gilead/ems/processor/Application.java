package com.gilead.ems.processor;

import java.io.IOException;
import java.text.ParseException;

import com.gilead.ems.csv.CSVProcessor;

/**
 * Hello world!
 *
 */
public class Application {
	public static void main(String[] args) {
		String fileName ="D:\\Gilead_projects\\ems-standalone\\src\\main\\java\\com\\gilead\\ems\\processor\\Gilead_Employee_Details.csv";
		CSVProcessor csvProcessor = new CSVProcessor();
		try {
			csvProcessor.getAllTrainees(fileName);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		
		} 
	}

