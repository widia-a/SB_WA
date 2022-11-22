package edu.widia.sbjdbcexample.repository;

import edu.widia.sbjdbcexample.model.DimScenario;

import java.util.List;

//public interface DimScenarioRepository {
public interface DimScenarioRepository {

    int save(DimScenario ds);
    int update(DimScenario ds);
    DimScenario findById(long id);
    int deleteById(long id);
    List<DimScenario> findAll();
    List<DimScenario> findByScenarioName(String scenarioName);
    int deleteAll();

}
