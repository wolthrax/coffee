package by.home.hryhoryeu.coffee.dba.dao;

import by.home.hryhoryeu.coffee.entities.CoffeeType;

import java.util.List;

public interface ICoffeeTypeDAO extends IBaseDAO<CoffeeType, Long>{
    List<CoffeeType> getEnabledCoffeeType();
}
