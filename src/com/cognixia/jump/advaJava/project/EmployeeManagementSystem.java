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
	File file = new File("resources/employees.txt");
	FileWriter fileWriter = null;
	BufferedWriter buffWriter = null;
	PrintWriter printWriter = null;
	protected String inputName;
	FileReader fileReader = null;
	BufferedReader reader = null;

	
	protected void newEmployee(String name){
		
		try {
			fileWriter = new FileWriter(file);
			buffWriter = new BufferedWriter(fileWriter);
			printWriter = new PrintWriter(buffWriter);
		
			//printWriter.println("ID 1," +name+",Fishing");
			//System.out.println("Success, new employee created!");
			
		} catch (IOException e) {
			// TODO: handle exception
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
	
	protected void removeEmployee(){
		
	}
	
	protected void updateEmployee() {
		
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
