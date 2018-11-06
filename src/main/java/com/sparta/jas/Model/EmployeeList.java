package com.sparta.jas.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeList {
    private Map<String, Employee> dataMap = new HashMap<>();
    private List<Employee> dupeList = new ArrayList<>();

    public void add(Employee employeeToAdd){
        if(!dataMap.containsKey(employeeToAdd.getId())){
            dataMap.put(employeeToAdd.getId(), employeeToAdd);
        } else {
            dupeList.add(employeeToAdd);
        }
    }

    public Employee getEmployee(String key){
        return dataMap.get(key);
    }

    public Map<String, Employee> getDataMap() {
        return dataMap;
    }

    public List<Employee> getDupeList() {
        return dupeList;
    }

//    public EmployeeList copyFrom(int startPoint, int endPoint){
//        EmployeeList copiedList = new EmployeeList();
//        for(int i = startPoint; i < endPoint-1; i++){
//            String line = getDataMap().values()..toString();
//            copiedList.add(getEmployee(line));
//        }
//        return copiedList;
//    }
}
