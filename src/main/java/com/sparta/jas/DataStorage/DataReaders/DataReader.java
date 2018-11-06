package com.sparta.jas.DataStorage.DataReaders;

import com.sparta.jas.Model.EmployeeList;

public interface DataReader {
    EmployeeList populateList();
    EmployeeList streamList();
}
