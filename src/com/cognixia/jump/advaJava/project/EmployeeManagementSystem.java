package com.cognixia.jump.advaJava.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EmployeeManagementSystem {
	protected File file = new File("resources/employees.txt");
	protected FileWriter fileWriter = null;
	protected BufferedWriter buffWriter = null;
	protected PrintWriter printWriter = null;
	protected String inputName;
	protected FileReader fileReader = null;
	protected BufferedReader reader = null;

	
	protected void newEmployee(String newID, String newName, String newDepartment){
		
		try {
			FileWriter fileWriter = new FileWriter(file,true);

			fileWriter.write(newID + "," + newName + "," + newDepartment + System.getProperty( "line.separator" ));
			System.out.println("Success, new employee created!");
			fileWriter.close();


		} catch (IOException e) {
			System.out.println("IOEXCEPTION!");
			e.printStackTrace();
		} finally {
			if(buffWriter != null) {
				try {
					buffWriter.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
			if(fileWriter != null) {
				try {
					fileWriter.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
			if(printWriter != null) {
				printWriter.close();
			}
		}
	}
	
	
	protected void listEmployeeInfo() {
		//print the file in employee

		try {
			fileReader = new FileReader(file);
			reader = new BufferedReader(fileReader);

			System.out.println("CONTEXT OF FILE!");
			System.out.println("======================");

			String line;
			while ((line = reader.readLine()) != null) {
					System.out.println(line);					
			}

		} catch (FileNotFoundException e) {
			System.out.println("EXCEPTION could not find file");
		} catch (IOException e) {
			System.out.println("EXCEPTION could not read character");
		} finally {
			try {
				fileReader.close();
				reader.close();
			} catch(IOException e) {
				System.out.println("CANT DO IT SIR!");
			}
		}
	}

}
