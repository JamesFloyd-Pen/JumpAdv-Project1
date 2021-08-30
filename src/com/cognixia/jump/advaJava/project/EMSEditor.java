package com.cognixia.jump.advaJava.project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class EMSEditor extends EmployeeManagementSystem{
    
    private ArrayList<String> index = new ArrayList<String>();

    @Override
    protected void listEmployeeInfo() {
       
		try {
			fileReader = new FileReader(file);
			reader = new BufferedReader(fileReader);

            System.out.println("CONTEXT OF FILE!");
			System.out.println("======================");
			String line;
			while ((line = reader.readLine()) != null) {
					System.out.println(line);
                    index.add(line);					
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
				System.out.println("Error! Unable to close filereader!");
			}
		}
    }

    protected void updateEmployee(String ID, String Name, String oldDepartment, String newDepartment){
        try {
            listEmployeeInfo();
            String temp= ID+","+Name+","+oldDepartment;
            int i = index.indexOf(temp);

            if(i >=0){
                temp = ID+","+Name+","+newDepartment;
                index.set(i, temp);
                System.out.println(index);
                arrayListToFile();

            } else{
                checkID(i);
            }

        } catch (Exception e) {
			e.printStackTrace();
        }
    }

    protected void removeEmployee(String ID){
		try {
            listEmployeeInfo();

            Optional<String> searchResult = index.stream()
            .filter(value -> value != null)
            .filter(value -> value.contains(ID))
            .findFirst();
            if(searchResult.isPresent()){
                System.out.println(searchResult);

            }else{
                System.out.println("No ID exists");
            }
		} catch (Exception e) {
            System.out.println("Exception Error has occured!");
		}
	}



    public void checkID(int input) throws FindIDException{

		if(input < 0){
			new FindIDException();
        }
	}

    public void arrayListToFile(){
        try {
            FileWriter fileWriter = new FileWriter(file,false);
            for(String newLine: index) {
                fileWriter.write(newLine + System.lineSeparator());
              }
            System.out.print("Success!");
            fileWriter.close();
            
        } catch (IOException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
	
}
