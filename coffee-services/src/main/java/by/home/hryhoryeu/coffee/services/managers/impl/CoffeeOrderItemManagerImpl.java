package by.home.hryhoryeu.coffee.services.managers.impl;

import by.home.hryhoryeu.coffee.dba.dao.ICoffeeOrderDAO;
import by.home.hryhoryeu.coffee.dba.dao.ICoffeeOrderItemDAO;
import by.home.hryhoryeu.coffee.dto.CoffeeOrderDTO;
import by.home.hryhoryeu.coffee.dto.CoffeeTypeDTO;
import by.home.hryhoryeu.coffee.entities.CoffeeOrder;
import by.home.hryhoryeu.coffee.entities.CoffeeOrderItem;
import by.home.hryhoryeu.coffee.services.convertors.CoffeeOrderToDTO;
import by.home.hryhoryeu.coffee.services.convertors.CoffeeTypeToDTO;
import by.home.hryhoryeu.coffee.services.managers.ICoffeeOrderItemManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Scope("singleton")
public class CoffeeOrderItemManagerImpl implements ICoffeeOrderItemManager{

    @Autowired
    private ICoffeeOrderItemDAO coffeeOrderItemDAO;

    @Autowired
    private ICoffeeOrderDAO coffeeOrderDAO;

    @Autowired
    private CoffeeOrderToDTO coffeeOrderToDTO;

    @Autowired
    private CoffeeTypeToDTO coffeeTypeToDTO;

    @Override
    public void addCoffeeOrderItem(CoffeeOrderDTO coffeeOrderDTO) {
        CoffeeOrderItem coffeeOrderItem ;
        CoffeeOrder coffeeOrder = coffeeOrderToDTO.convertFrom(coffeeOrderDTO);
        coffeeOrderDAO.add(coffeeOrder);

        for(CoffeeTypeDTO coffeeTypeDTO : coffeeOrderDTO.getCoffeeTypeDTOList()){
            coffeeOrderItem = new CoffeeOrderItem();
            coffeeOrderItem.setCoffeeOrder(coffeeOrder);
            coffeeOrderItem.setCoffeeType(coffeeTypeToDTO.convertFrom(coffeeTypeDTO));
            coffeeOrderItem.setQuantity(coffeeTypeDTO.getQuantity());
            coffeeOrderItemDAO.add(coffeeOrderItem);
        }
    }
}
