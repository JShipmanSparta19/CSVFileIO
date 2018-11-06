package com.sparta.jas;

import com.sparta.jas.DataStorage.DataReaders.CSVDataReader;
import com.sparta.jas.DataStorage.TransferTable.CreateTable;
import com.sparta.jas.DataStorage.TransferTable.PopulateTable;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CreateTable tableMaker = new CreateTable();
        tableMaker.createTable();
        PopulateTable tableFiller = new PopulateTable();
        tableFiller.populateTable();
//        tableMaker.addPrimaryKey();
    }
}
