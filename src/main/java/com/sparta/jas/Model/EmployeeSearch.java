package com.sparta.jas.Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class EmployeeSearch {
    private EmployeeList employeeList;

    public EmployeeSearch(EmployeeList employeeList) {
        this.employeeList = employeeList;
    }

    public List<Employee> searchByFirstName(String value) {
        List<Employee> searchResults = new ArrayList<>();
        for (Employee employee: employeeList.getDataMap().values()) {
            if (employee.getFirstName().equals(value)){
                searchResults.add(employee);
            }
        }
        return searchResults;
    }

    public List<Employee> searchByID(String value) {
        List<Employee> searchResults = new ArrayList<>();
        for (Employee employee: employeeList.getDataMap().values()) {
            if (employee.getId().equals(value)){
                searchResults.add(employee);
            }
        }
        return searchResults;
    }

    public List<Employee> searchByPrefix(String value) {
        List<Employee> searchResults = new ArrayList<>();
        for (Employee employee: employeeList.getDataMap().values()) {
            if (employee.getPrefix().equals(value)){
                searchResults.add(employee);
            }
        }
        return searchResults;
    }

    public List<Employee> searchByMiddleInitial(String value) {
        List<Employee> searchResults = new ArrayList<>();
        for (Employee employee: employeeList.getDataMap().values()) {
            if (employee.getMidInitial().equals(value)){
                searchResults.add(employee);
            }
        }
        return searchResults;
    }

    public List<Employee> searchBySurname(String value) {
        List<Employee> searchResults = new ArrayList<>();
        for (Employee employee: employeeList.getDataMap().values()) {
            if (employee.getLastName().equals(value)){
                searchResults.add(employee);
            }
        }
        return searchResults;
    }

    public List<Employee> searchByGender(String gender) {
        boolean value = gender.equals("F");
        List<Employee> searchResults = new ArrayList<>();
        for (Employee employee: employeeList.getDataMap().values()) {
            if (employee.isFemale() == value){
                searchResults.add(employee);
            }
        }
        return searchResults;
    }

    public List<Employee> searchByEmail(String value) {
        List<Employee> searchResults = new ArrayList<>();
        for (Employee employee: employeeList.getDataMap().values()) {
            if (employee.getEmail().equals(value)){
                searchResults.add(employee);
            }
        }
        return searchResults;
    }

    public List<Employee> searchBySalary(int value) {
        List<Employee> searchResults = new ArrayList<>();
        for (Employee employee: employeeList.getDataMap().values()) {
            if (employee.getSalary() == value){
                searchResults.add(employee);
            }
        }
        return searchResults;
    }

//    public List<Employee> searchByBirthYear(int value) {
//        List<Employee> searchResults = new ArrayList<>();
//        for (Employee employee: employeeList.getDataMap().values()) {
//            Calendar calendar = new GregorianCalendar();
//            calendar.setTime(employee.getDateOfBirth());
//            if (calendar.get(Calendar.YEAR) == value){
//                searchResults.add(employee);
//            }
//        }
//        return searchResults;
//    }
//
//    public List<Employee> searchByStartYear(int value) {
//        List<Employee> searchResults = new ArrayList<>();
//        for (Employee employee: employeeList.getDataMap().values()) {
//            Calendar calendar = new GregorianCalendar();
//            calendar.setTime(employee.getDateOfJoining());
//            if (calendar.get(Calendar.YEAR) == value){
//                searchResults.add(employee);
//            }
//        }
//        return searchResults;
//    }

    public List<String> searchForDupes() {
        List<String> searchResults = new ArrayList<>();
        for (Employee employee : employeeList.getDataMap().values()) {
            for (Employee employeeDupe: employeeList.getDupeList()) {
                if (employee.getId().equals(employeeDupe.getId())){
                    searchResults.add("------\n" + employee.toString() + "\n" + employeeDupe.toString());
                }
            }
        }
        return searchResults;
    }
}
