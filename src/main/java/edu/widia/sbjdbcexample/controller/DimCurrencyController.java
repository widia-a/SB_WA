package edu.widia.sbjdbcexample.controller;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 22/11/2022 13:42
Last modified on 13:42
Version 1.0
*/


import edu.widia.sbjdbcexample.model.DimCurrency;
import edu.widia.sbjdbcexample.repository.DimCurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DimCurrencyController {
    @Autowired
    DimCurrencyRepository dimCurrencyRepository;

    @GetMapping("/dimcurrencies/{id}")
    public ResponseEntity<DimCurrency> getDimCurrencyById(@PathVariable("id") long id){
        DimCurrency dimCurrency = dimCurrencyRepository.findById(id);

        if (dimCurrency != null){
            return new ResponseEntity<>(dimCurrency, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/dimcurrencies")
    public ResponseEntity<String> createDimCurrency(@RequestBody DimCurrency dimCurrency){
        try {
            dimCurrencyRepository.save(new DimCurrency(dimCurrency.getCurrencyname(), dimCurrency.getCurrencyalternatekey()));
            return new ResponseEntity<>("Data berhasil dibuat.", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/dimcurrencies/{id}")
    public ResponseEntity<String> updateDimCurrency(@PathVariable("id") long id, @RequestBody DimCurrency dimCurrency){
        DimCurrency _dimCurrency = dimCurrencyRepository.findById(id);

        if (_dimCurrency != null){
            _dimCurrency.setCurrencykey(id);
            _dimCurrency.setCurrencyname(dimCurrency.getCurrencyname());
            _dimCurrency.setCurrencyalternatekey(dimCurrency.getCurrencyalternatekey());

            dimCurrencyRepository.update(_dimCurrency);
            return new ResponseEntity<>("Data berhasil diperbaharui.", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("tidak dapat menemukan data dengan id=" + id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/dimcurrencies/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") long id){
        try{
            int result = dimCurrencyRepository.deleteById(id);
            if (result == 0){
                return new ResponseEntity<>("Data dengan id "+ id + " tidak ada!!", HttpStatus.OK);
            }
            return new ResponseEntity<>("Data dengan id " + id + " berhasil dihapus.", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Tidak dapat menghapus data.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/dimcurrencies/6832BLE")
    public ResponseEntity<String> deleteALL(){
        try {
            int numRows = dimCurrencyRepository.deleteAll();
            return new ResponseEntity<>("Berhasil menghapus " + numRows + " data.", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Tidak dapat menghapus data.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/dimcurrencies/datas/{name}")
    public ResponseEntity<List<DimCurrency>> findByCurrencyName(@PathVariable("name") String name){
        try {
            List<DimCurrency> lsDimCurrency = dimCurrencyRepository.findByName(name);

            if (lsDimCurrency.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(lsDimCurrency, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
