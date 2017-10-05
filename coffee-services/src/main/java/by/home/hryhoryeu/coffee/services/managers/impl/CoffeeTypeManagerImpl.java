package by.home.hryhoryeu.coffee.services.managers.impl;

import by.home.hryhoryeu.coffee.dba.dao.ICoffeeTypeDAO;
import by.home.hryhoryeu.coffee.dto.CoffeeTypeDTO;
import by.home.hryhoryeu.coffee.entities.CoffeeType;
import by.home.hryhoryeu.coffee.services.convertors.CoffeeTypeToDTO;
import by.home.hryhoryeu.coffee.services.managers.ICoffeeTypeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Scope("singleton")
public class CoffeeTypeManagerImpl implements ICoffeeTypeManager{

    @Autowired
    private ICoffeeTypeDAO coffeeTypeDAO;

    @Autowired
    private CoffeeTypeToDTO coffeeTypeToDTO;

    @Override
    public List<CoffeeTypeDTO> getCoffeeType() {
        List<CoffeeType> coffeeTypeList = coffeeTypeDAO.getEnabledCoffeeType();
        List<CoffeeTypeDTO> coffeeTypeDTOList = new ArrayList<>();
        for(CoffeeType coffeeType : coffeeTypeList){
            coffeeTypeDTOList.add(coffeeTypeToDTO.convertTo(coffeeType));
        }
        return coffeeTypeDTOList;
    }
}
