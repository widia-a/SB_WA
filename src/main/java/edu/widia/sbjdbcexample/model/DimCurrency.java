package edu.widia.sbjdbcexample.model;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 22/11/2022 13:18
Last modified on 13:18
Version 1.0
*/


public class DimCurrency {

    private long currencykey;

    private String currencyalternatekey;

    private String currencyname;

    public DimCurrency(){}

    public DimCurrency(long currencykey, String currencyAlternateKey, String currencyName){
        this.currencykey = currencykey;
        this.currencyalternatekey = currencyAlternateKey;
        this.currencyname = currencyName;
    }

    public DimCurrency(String currencyname, String currencyalternatekey){
        this.currencyname = currencyname;
        this.currencyalternatekey = currencyalternatekey;
    }

    public long getCurrencykey(){
        return currencykey;
    }

    public void setCurrencykey(long currencykey){
        this.currencykey = currencykey;
    }

    public String getCurrencyname(){
        return currencyname;
    }

    public void setCurrencyname(String currencyname){
        this.currencyname = currencyname;
    }

    public String getCurrencyalternatekey(){
        return currencyalternatekey;
    }

    public void setCurrencyalternatekey(String currencyalternatekey){
        this.currencyalternatekey = currencyalternatekey;
    }

}
