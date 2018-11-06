package com.sparta.jas.DataStorage.DataReaders;

import com.sparta.jas.Model.Employee;

public interface DAO extends DataReader {

    void daoGet();

    void daoAdd();

    void daoUpdate();

    void daoDelete();
}
