package by.home.hryhoryeu.coffee.services.convertors;

import by.home.hryhoryeu.coffee.dto.CoffeeTypeDTO;
import by.home.hryhoryeu.coffee.entities.CoffeeType;
import org.springframework.stereotype.Component;

@Component
public class CoffeeTypeToDTO {

    public CoffeeTypeDTO convertTo(CoffeeType coffeeType){
        CoffeeTypeDTO dto = new CoffeeTypeDTO();
        dto.setId(coffeeType.getId());
        dto.setTypeName(coffeeType.getTypeName());
        dto.setPrice(coffeeType.getPrice());
        return dto;
    }

    public CoffeeType convertFrom(CoffeeTypeDTO dto){
        CoffeeType coffeeType = new CoffeeType();
        coffeeType.setId(dto.getId());
        coffeeType.setPrice(dto.getPrice());
        coffeeType.setTypeName(dto.getTypeName());
        return  coffeeType;
    }
}
