package by.home.hryhoryeu.coffee.services.algorithms;

import by.home.hryhoryeu.coffee.dba.dao.IConfigurationDAO;
import by.home.hryhoryeu.coffee.dto.CoffeeOrderDTO;
import by.home.hryhoryeu.coffee.dto.CoffeeTypeDTO;
import by.home.hryhoryeu.coffee.dto.ConfigurationDTO;
import by.home.hryhoryeu.coffee.services.convertors.ConfigurationToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Algorithm {

    @Autowired
    private IConfigurationDAO configurationDAO;

    @Autowired
    private ConfigurationDTO configurationDTO;

    @Autowired
    private ConfigurationToDTO configurationToDTO;

    public CoffeeOrderDTO costCalculate(CoffeeOrderDTO coffeeOrderDTO) {

        if(configurationDTO.getDefaultConfig())
            configurationDTO = configurationToDTO.convertTo(configurationDAO.getAll());

        double sum = 0;

        for(CoffeeTypeDTO coffeeTypeDTO : coffeeOrderDTO.getCoffeeTypeDTOList()){
            coffeeTypeDTO.setCost(coffeeTypeDTO.getQuantity() *
                    coffeeTypeDTO.getPrice() -
                    coffeeTypeDTO.getPrice() *
                    Math.floorDiv(coffeeTypeDTO.getQuantity(), configurationDTO.getN()));
            sum += coffeeTypeDTO.getCost();
        }

        coffeeOrderDTO.setSum(sum);

        if(sum > configurationDTO.getX())
            coffeeOrderDTO.setDelivery(0);
        else coffeeOrderDTO.setDelivery(configurationDTO.getM());

        coffeeOrderDTO.setTotal(sum + coffeeOrderDTO.getDelivery());

        return coffeeOrderDTO;
    }

}
