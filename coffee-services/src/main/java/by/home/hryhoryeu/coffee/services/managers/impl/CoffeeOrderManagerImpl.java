package by.home.hryhoryeu.coffee.services.managers.impl;

import by.home.hryhoryeu.coffee.dba.dao.ICoffeeTypeDAO;
import by.home.hryhoryeu.coffee.dto.CoffeeOrderDTO;
import by.home.hryhoryeu.coffee.dto.CoffeeTypeDTO;
import by.home.hryhoryeu.coffee.dto.SelectedItemsDTO;
import by.home.hryhoryeu.coffee.services.algorithms.Algorithm;
import by.home.hryhoryeu.coffee.services.convertors.CoffeeTypeToDTO;
import by.home.hryhoryeu.coffee.services.managers.ICoffeeOrderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Scope("singleton")
public class CoffeeOrderManagerImpl implements ICoffeeOrderManager{

    @Autowired
    private ICoffeeTypeDAO coffeeTypeDAO;

    @Autowired
    private CoffeeTypeToDTO coffeeTypeToDTO;

    @Autowired
    private Algorithm algorithm;

    @Override
    public CoffeeOrderDTO calculateTheOrderAmount(SelectedItemsDTO selectedItemsDTO) {

        CoffeeOrderDTO coffeeOrderDTO = new CoffeeOrderDTO();
        List<CoffeeTypeDTO> selectedCoffeeTypes = new ArrayList<>();

        CoffeeTypeDTO coffeeTypeDTO;

        for(int i = 0; i < selectedItemsDTO.getSelectedTypes().size(); i++){
            coffeeTypeDTO = coffeeTypeToDTO.convertTo(coffeeTypeDAO.get(selectedItemsDTO.getSelectedTypes().get(i)));
            coffeeTypeDTO.setQuantity(Integer.valueOf(selectedItemsDTO.getQuantitySelectedItems().get(i)));
            selectedCoffeeTypes.add(coffeeTypeDTO);
        }

        coffeeOrderDTO.setCoffeeTypeDTOList(selectedCoffeeTypes);
        algorithm.costCalculate(coffeeOrderDTO);


        return coffeeOrderDTO;
    }
}
