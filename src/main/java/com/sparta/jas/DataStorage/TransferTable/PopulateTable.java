package com.sparta.jas.DataStorage.TransferTable;

import com.sparta.jas.DataStorage.DataReaders.CSVDataReader;
import com.sparta.jas.DataStorage.DataReaders.DataReader;
import com.sparta.jas.DataStorage.DataReaders.EmployeeDAO;
import com.sparta.jas.Model.Employee;
import com.sparta.jas.Model.EmployeeList;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PopulateTable {
    private final String PATH = "jdbc:oracle:thin:@localhost:1521:xe";
    private final String USER = "";
    private final String PASSWORD = "";
    private EmployeeDAO employeeDAO;
    private EmployeeList employeeList;

    public void populateTable(){
        employeeDAO = new EmployeeDAO();
        DataReader dataReader = new CSVDataReader("C:\\Users\\TECH-W92\\Engineering19\\Week6\\Day5\\CSVFileIO\\resources\\Employee Records.csv");
        employeeList = dataReader.populateList();
        try (Connection connection = DriverManager.getConnection(PATH, USER, PASSWORD)){
            int maxCursors = employeeList.getDataMap().size();
            PreparedStatement openCursors = connection.prepareStatement("ALTER SYSTEM SET open_cursors = " +
                    maxCursors +
                    " SCOPE=BOTH");
            openCursors.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Thread[] threadArr = new Thread[10];
        int threadIndex = 0;
        EmployeeList employeeSublist = new EmployeeList();
        EmployeeList iteratedList = new EmployeeList();
        List<ListThread> listThreads = new ArrayList<>();
        for(Employee employee:employeeList.getDataMap().values()){
            if (!iteratedList.getDataMap().containsKey(employee.getId())){
                iteratedList.add(employee);
                employeeSublist.add(employee);
                if (employeeSublist.getDataMap().size() == 1000){
                    ListThread listThread = new ListThread(employeeSublist);//Check the listThread object, is it recovering this?
                    listThreads.add(listThread);
                    threadArr[threadIndex] = new Thread(listThread);
                    threadArr[threadIndex].start();
                    threadIndex++;
                    employeeSublist.getDataMap().clear();
                }
            }
        }
    }

    private class ListThread implements Runnable {
        EmployeeList employeeSublist;

        private ListThread(EmployeeList employeeSublist) {
            this.employeeSublist = employeeSublist;
        }

        @Override
        public void run() {
            ((EmployeeDAO) employeeDAO).employeesAdd(employeeSublist);
        }
    }
}
