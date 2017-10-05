package by.home.hryhoryeu.coffee.services.convertors;

import by.home.hryhoryeu.coffee.dto.CoffeeOrderDTO;
import by.home.hryhoryeu.coffee.entities.CoffeeOrder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CoffeeOrderToDTO {

    public CoffeeOrder convertFrom(CoffeeOrderDTO coffeeOrderDTO){
        CoffeeOrder coffeeOrder = new CoffeeOrder();
        coffeeOrder.setName(coffeeOrderDTO.getName());
        coffeeOrder.setDeliveryAddress(coffeeOrderDTO.getAddress());
        coffeeOrder.setCost(coffeeOrderDTO.getTotal());
        coffeeOrder.setOrderDate(new Date());

        return coffeeOrder;
    }

}
