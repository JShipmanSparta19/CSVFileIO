package com.sparta.jas.DataStorage.TransferTable;

import com.sparta.jas.DataStorage.DataReaders.CSVDataReader;
import com.sparta.jas.DataStorage.DataReaders.DataReader;

import java.io.IOException;
import java.sql.*;

public class CreateTable {
    private final String PATH = "jdbc:oracle:thin:@localhost:1521:xe";
    private final String USER = "hr";
    private final String PASSWORD = "hr";
//    private final String addColumnQuery = "ALTER TABLE CSV_EMPLOYEES ADD ?";

    public void createTable(){
        DataReader dataReader = new CSVDataReader("C:\\Users\\TECH-W92\\Engineering19\\Week6\\Day5\\CSVFileIO\\resources\\Employee Records.csv");
        try (Connection connection = DriverManager.getConnection(PATH, USER, PASSWORD)){
            String line = ((CSVDataReader) dataReader).reader.readLine();
            String[] columns = line.split(",");
            for (int i = 0; i<columns.length;i++) {
                columns[i] = columns[i].replaceAll(" ", "_");
            }
            String dataType;
            PreparedStatement destroyer = connection.prepareStatement("DROP TABLE CSV_EMPLOYEES");
            PreparedStatement creator = connection.prepareStatement("CREATE TABLE CSV_EMPLOYEES(EMP_ID varchar2(50))");
            destroyer.executeQuery();
            creator.executeQuery();
            for (int i = 1; i<columns.length; i++) {
                switch (columns[i]){
                    case "Salary":
                        dataType = "int";
                        break;
                    case "Date_of_Birth": case "Date_of_Joining":
                        dataType = "date";
                        break;
                    default:
                        dataType = "VARCHAR2(50)";
                        break;
                }
                String columnNameAndType = columns[i] + " " + dataType;
                String addColumnQuery = "ALTER TABLE CSV_EMPLOYEES ADD " + columnNameAndType;
                PreparedStatement addColumn = connection.prepareStatement(addColumnQuery);
//                addColumn.setString(1, columnNameAndType);
                addColumn.execute();
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPrimaryKey(){
        try (Connection connection = DriverManager.getConnection(PATH, USER, PASSWORD)) {
            PreparedStatement primaryKey = connection.prepareStatement("ALTER TABLE CSV_EMPLOYEES\n" +
                    "ADD PRIMARY KEY (EMP_ID)");
            primaryKey.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
