package com.cognixia.jump.advaJava.project;

import java.util.Scanner;

public class EmployeeMain{
	/*
		Global variables to call classes in main class.
	*/

	static EmployeeManagementSystem ems1 = new EmployeeManagementSystem();
	static EMSEditor ems2 = new EMSEditor();


	public static void main(String[] arg) {
		boolean onLoop = true;
		Scanner input = new Scanner(System.in);

		//System Print Out Interface
		System.out.println("Welcome to JFloyd Emplyee Management System! \n" +
		"Please insert a number to continue");
		
		while(onLoop){
			mainMenu();
			int indexPointer = input.nextInt();

			switch(indexPointer){
				case 1:
					ems1.listEmployeeInfo();
					break;
				case 2:
					insertNewEmployeeHelper();
					break;
				case 3:
					updateEmployeeHelper();					
					break;
				case 4:
					deleteEmployeeHelper();
					break;
				case 5:
					findDepartmentHelper();
					break;
				case 6:
					System.out.println("Goodbye!");
					onLoop = false;
					break;
				default:
					System.out.println("ERROR! Please Enter a valid integer");
					break;
	
			}
		}
		input.close();
	}

	private static void insertNewEmployeeHelper() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Insert new ID");
		String newID = input.nextLine();
		
		System.out.println("Insert name");
		String newName = input.nextLine();

		System.out.println("Insert Department");
		String newDepartment = input.nextLine();

		ems1.newEmployee(newID, newName, newDepartment);
	}

	private static void updateEmployeeHelper() {
		//Not the most efficent code. 
		Scanner input = new Scanner(System.in);
		
		System.out.println("Insert Employee's ID");
		String newID = input.nextLine();
		
		System.out.println("Insert Current name");
		String newName = input.nextLine();

		System.out.println("Insert Old Department");
		String oldDepartment = input.nextLine();

		System.out.println("Insert New Department");
		String newDepartment = input.nextLine();

		ems2.updateEmployee(newID, newName, oldDepartment, newDepartment);
	}

	private static void deleteEmployeeHelper() {
		Scanner input = new Scanner(System.in);

		System.out.println("Insert ID to delete");
		String newID = input.nextLine();

		ems2.removeEmployee(newID);
	}

	public static void findDepartmentHelper(){
		Scanner input = new Scanner(System.in);

		System.out.println("Insert name of Department to find");
		String Department = input.nextLine();

		ems2.printDepartment(Department);

	}

	public static void mainMenu(){
		System.out.println("===Main Menu===");
		System.out.println("1. Print List of Employees");
		System.out.println("2. Add a new Employee");
		System.out.println("3. Update Employee");
		System.out.println("4. Delete Employee");
		System.out.println("5. Find Department");
		System.out.println("6. Exit");

	}
}
