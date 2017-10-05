package by.home.hryhoryeu.coffee.services.managers;

import by.home.hryhoryeu.coffee.dto.CoffeeOrderDTO;
import by.home.hryhoryeu.coffee.dto.SelectedItemsDTO;

public interface ICoffeeOrderManager {

    CoffeeOrderDTO calculateTheOrderAmount(SelectedItemsDTO selectedItemsDTO);
}
