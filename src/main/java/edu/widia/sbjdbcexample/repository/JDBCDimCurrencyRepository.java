package edu.widia.sbjdbcexample.repository;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 22/11/2022 14:30
Last modified on 14:30
Version 1.0
*/

import edu.widia.sbjdbcexample.model.DimCurrency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JDBCDimCurrencyRepository implements DimCurrencyRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(DimCurrency dcr){
        return jdbcTemplate.update("INSERT INTO DimCurrency (CurrencyAlternateKey,CurrencyName) VALUES(?,?)",
                new Object[] {dcr.getCurrencyalternatekey(), dcr.getCurrencyname()});
    }

    @Override
    public int update(DimCurrency dcr) {
        return jdbcTemplate.update("UPDATE DimCurrency SET CurrencyAlternateKey=?, CurrencyName=? WHERE CurrencyKey=?",
                new Object[]{dcr.getCurrencyalternatekey(), dcr.getCurrencyname(), dcr.getCurrencykey()});
    }

    @Override
    public DimCurrency findById(long id){
        try {
            DimCurrency dimCurrency = jdbcTemplate.queryForObject("SELECT CurrencyKey,CurrencyAlternateKey,CurrencyName FROM DimCurrency WHERE CurrencyKey=?",
                    BeanPropertyRowMapper.newInstance(DimCurrency.class), id);

            return dimCurrency;
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public int deleteById(long id){

        return jdbcTemplate.update("DELETE FROM DimCurrency WHERE CurrencyKey=?", id);
    }

    public List<DimCurrency> findAll(){
        return jdbcTemplate.query("SELECT * FROM DimCurrency", BeanPropertyRowMapper.newInstance(DimCurrency.class));
    }

    @Override
    public List<DimCurrency> findByName(String name){
        return jdbcTemplate.query("SELECT * FROM DimCurrency WHERE CurrencyAlternateKey+CurrencyName LIKE CONCAT('%',?,'%')",
                BeanPropertyRowMapper.newInstance(DimCurrency.class), name);
    }

    @Override
    public int deleteAll() {
        return 0;
    }


}
