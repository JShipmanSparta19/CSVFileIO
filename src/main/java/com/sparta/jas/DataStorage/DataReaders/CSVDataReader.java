package com.sparta.jas.DataStorage.DataReaders;

import com.sparta.jas.Model.Employee;
import com.sparta.jas.Model.EmployeeList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class CSVDataReader implements DataReader {
    private String csvFile;
    public BufferedReader reader;

    public CSVDataReader(String filePath){
        csvFile = filePath;
        try {
            reader = new BufferedReader(new FileReader(csvFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

//    private Employee getEmployee(String line){
//        Employee dataLine;
//        String[] values = line.split(",");
//        try {
//            dataLine = new Employee(values[0],values[1],values[2],values[3],values[4],values[5],values[6],values[7],values[8],values[9]);
//            return dataLine;
//        } catch (ParseException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    public EmployeeList populateList(){
        try {
            EmployeeList employeeList = new EmployeeList();
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                Employee employeeToAdd = getEmployee(line.split(","));
                employeeList.add(employeeToAdd);
            }
            return employeeList;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public EmployeeList streamList(){
        EmployeeList employeeList = new EmployeeList();
        reader.lines()
                .filter(line -> !line.startsWith("Emp ID"))
                .map(line -> line.split(","))
                .forEach(line -> employeeList.add(getEmployee(line)));
//            while ((line = reader.readLine()) != null) {
//                Employee employeeToAdd = getEmployee(line);
//                employeeList.add(employeeToAdd);
//            }
        return employeeList;
    }

    private Employee getEmployee(String[] fields){
        Employee dataLine;
        try {
            dataLine = new Employee(fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9]);
            return dataLine;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
