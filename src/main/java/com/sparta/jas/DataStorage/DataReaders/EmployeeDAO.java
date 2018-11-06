package com.sparta.jas.DataStorage.DataReaders;

import com.sparta.jas.Model.Employee;
import com.sparta.jas.Model.EmployeeList;

import java.io.IOException;
import java.sql.*;

public class EmployeeDAO {

    private String sqlPath;
    private final String PATH = "jdbc:oracle:thin:@localhost:1521:xe";
    private final String USER = "hr";
    private final String PASSWORD = "hr";
    private Connection connection;

//    @Override
    public EmployeeList populateList() {
        return null;
    }

    public void daoGet() {
//        try (Connection connection = DriverManager.getConnection(sqlPath, USER, PASSWORD)) {
//            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setString(1, id);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                String firstName = resultSet.getString(1);
//                String lastName = resultSet.getString(2);
//                int salary = resultSet.getInt(3);
//                System.out.println(firstName + " " + lastName + " earns " + salary + " per month");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public void employeeAdd(Employee employee) {
        boolean singleAdd = false;
        try {
            if (connection == null){
                connection = DriverManager.getConnection(PATH, USER, PASSWORD);
                singleAdd = true;
            }
            PreparedStatement addRow = connection.prepareStatement("INSERT INTO CSV_EMPLOYEES(Emp_ID, Name_Prefix, First_Name, Middle_Initial, Last_Name, Gender, E_Mail, Date_of_Birth, Date_of_Joining, Salary) VALUES (?,?,?,?,?,?,?,?,?,?)");
            addRow.setString(1, employee.getId());
            addRow.setString(2, employee.getPrefix());
            addRow.setString(3, employee.getFirstName());
            addRow.setString(4, employee.getMidInitial());
            addRow.setString(5, employee.getLastName());
            addRow.setString(6, (employee.isFemale() ? "F":"M"));
            addRow.setString(7, employee.getEmail());
            addRow.setDate(8, Date.valueOf(employee.getDateOfBirth()));
            addRow.setDate(9, Date.valueOf(employee.getDateOfJoining()));
            addRow.setInt(10, employee.getSalary());
            addRow.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (singleAdd) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void employeesAdd(EmployeeList employeeList) {
        try {
            connection = DriverManager.getConnection(PATH, USER, PASSWORD);
            for (Employee employee: employeeList.getDataMap().values()) {
                employeeAdd(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
//} finally {
//        try {
//        connection.close();
//        } catch (SQLException e) {
//        e.printStackTrace();
//        }

public void daoUpdate() {

    }

    public void daoDelete() {

    }
}
