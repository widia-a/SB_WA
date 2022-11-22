package edu.widia.sbjdbcexample.repository;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 22/11/2022 14:23
Last modified on 14:23
Version 1.0
*/


import edu.widia.sbjdbcexample.model.DimCurrency;

import java.util.List;

public interface DimCurrencyRepository {
    int save(DimCurrency dcr);

    int update(DimCurrency dcr);

    DimCurrency findById(long id);

    int deleteById(long id);

    List<DimCurrency> findAll();

    List<DimCurrency> findByName(String name);

    int deleteAll();
}
