package com.cognixia.jump.advaJava.project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class EMSEditor extends EmployeeManagementSystem{
    
    private ArrayList<String> index = new ArrayList<String>();

    @Override
    protected void listEmployeeInfo() {
        //To handle index ArrayList
       
		try {
			fileReader = new FileReader(file);
			reader = new BufferedReader(fileReader);

			String line;
			while ((line = reader.readLine()) != null) {
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
            System.out.println(i);

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

        listEmployeeInfo();
        Iterator itr = index.iterator();
        while(itr.hasNext()){
        String x = (String)itr.next();
        if(x.contains(ID)) {
            itr.remove();
            }
        }
        System.out.println(index);
        arrayListToFile();
	}

    public void checkID(int input) throws FindIDException{

		if(input < 0){
			throw new FindIDException(input);
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

    public void printDepartment(String Department){
        listEmployeeInfo();
        for(String newLine: index) {
            if(newLine.contains(Department))
                System.out.println(newLine + "\n");
          }
    }
	
}
