//package com.sparta.jas;
//
//import com.sparta.jas.DataStorage.DataReaders.DataReader;
//import com.sparta.jas.DataStorage.DataReaders.EmployeeDAO;
//import com.sparta.jas.Model.Employee;
//import com.sparta.jas.Model.EmployeeList;
//import com.sparta.jas.Model.EmployeeSearch;
//import org.junit.Assert;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import java.util.List;
//
//public class EmployeeListDAOTest {
//    private static EmployeeList employeeList;
//
//    @BeforeClass
//    public static void setupClass(){
//        DataReader dataReader = new EmployeeDAO("C:\\Users\\TECH-W92\\Engineering19\\Week6\\Day5\\CSVFileIO\\resources\\Employee Records.csv");
//        employeeList = dataReader.populateList();
//    }
//
//    @Test
//    public void outputEmployeeTest(){
//        String expectedOutput = "Emp ID=260736, Name Prefix=Ms., First Name=Zelda, Middle Initial=P, Last Name=Forest, Gender=F, E Mail=zelda.forest@ibm.com, Date of Birth=Fri Nov 27 00:00:00 GMT 1959, Date of Joining=Tue Jan 28 00:00:00 GMT 2014, Salary=176642";
//        Employee listOutput = employeeList.getEmployee("260736");
//        Assert.assertEquals(expectedOutput, listOutput.toString());
//    }
//
//    @Test
//    public void searchByFirstName(){
//        EmployeeSearch employeeSearch = new EmployeeSearch(employeeList);
//        List searchResults = employeeSearch.searchByFirstName("Jonathan");
//        Assert.assertEquals(3, searchResults.size());
////        for (Object searchResult : searchResults) {
////            System.out.println(searchResult.toString());
////        }
//    }
//
//    @Test
//    public void searchByID(){
//        EmployeeSearch employeeSearch = new EmployeeSearch(employeeList);
//        String expectedOutput = "Emp ID=260736, Name Prefix=Ms., First Name=Zelda, Middle Initial=P, Last Name=Forest, Gender=F, E Mail=zelda.forest@ibm.com, Date of Birth=Fri Nov 27 00:00:00 GMT 1959, Date of Joining=Tue Jan 28 00:00:00 GMT 2014, Salary=176642";
//        List searchResults = employeeSearch.searchByID("260736");
//        Assert.assertEquals(expectedOutput, searchResults.get(0).toString());
//    }
//
//    @Test
//    public void dupeTest(){
////        EmployeeSearch employeeSearch = new EmployeeSearch(employeeList);
////        List searchResults = employeeSearch.searchForDupes();
//        Assert.assertEquals(employeeList.getDataMap().get("945178").getId(), employeeList.getDupeList().get(0).getId());
//    }
//}
