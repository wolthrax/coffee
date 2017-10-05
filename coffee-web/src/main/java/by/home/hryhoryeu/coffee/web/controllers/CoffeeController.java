package by.home.hryhoryeu.coffee.web.controllers;

import by.home.hryhoryeu.coffee.dto.CoffeeOrderDTO;
import by.home.hryhoryeu.coffee.dto.CoffeeTypeDTO;
import by.home.hryhoryeu.coffee.dto.SelectedItemsDTO;
import by.home.hryhoryeu.coffee.services.managers.ICoffeeOrderItemManager;
import by.home.hryhoryeu.coffee.services.managers.ICoffeeOrderManager;
import by.home.hryhoryeu.coffee.services.managers.ICoffeeTypeManager;
import by.home.hryhoryeu.coffee.web.validators.BaseValidator;
import by.home.hryhoryeu.coffee.web.validators.OrderValidator;
import by.home.hryhoryeu.coffee.web.validators.SelectedItemsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class CoffeeController {

    @Autowired
    private ICoffeeTypeManager coffeeTypeManager;

    @Autowired
    private ICoffeeOrderManager coffeeOrderManager;

    @Autowired
    private ICoffeeOrderItemManager coffeeOrderItemManager;

    @Autowired
    private SelectedItemsValidator selectedItemsValidator;

    @Autowired
    private OrderValidator orderValidator;

    @Autowired
    private BaseValidator baseValidator;

    private List<CoffeeTypeDTO> coffeeTypeDTOList;
    private CoffeeOrderDTO coffeeOrderDTO;

    @ModelAttribute(value = "selectedItemsDTO")
    public SelectedItemsDTO selectedItemsDTO(){
        return new SelectedItemsDTO();
    }

    @ModelAttribute(value = "coffeeOrderDTO")
    public CoffeeOrderDTO orderItemDTO(){
        return coffeeOrderDTO;
    }

    @InitBinder("selectedItemsDTO")
    private void selectedItemsBinder(WebDataBinder binder) {
        binder.setValidator(selectedItemsValidator);
    }

    @InitBinder("coffeeOrderDTO")
    private void coffeeOrderDTOBinder(WebDataBinder binder) {
        binder.setValidator(orderValidator);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getCoffeeType(Model model){
        ModelAndView view = new ModelAndView("definition-coffeelist");
        coffeeTypeDTOList = coffeeTypeManager.getCoffeeType();
        if(coffeeTypeDTOList != null){
            model.addAttribute("coffeeTypeDTOList", coffeeTypeDTOList);
        }
        return view;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView calculateTheOrderAmounts(SelectedItemsDTO selectedItemsDTO, BindingResult result, Model model){

        ModelAndView view = new ModelAndView();
        selectedItemsValidator.validate(selectedItemsDTO, result);
        if(result.hasErrors()){
            view.setViewName("definition-coffeelist");
            model.addAttribute("coffeeTypeDTOList", coffeeTypeDTOList);
            model.addAttribute("error" , result.getAllErrors().get(0).getDefaultMessage());
            return view;
        } else {
            view.setViewName("definition-orderlist");
            coffeeOrderDTO = coffeeOrderManager.calculateTheOrderAmount(selectedItemsDTO);
            view.addObject("coffeeOrderDTO", coffeeOrderDTO);
            return view;
        }
    }

    @RequestMapping(value = "addOrder", method = RequestMethod.POST)
    public ModelAndView addOrderItem(CoffeeOrderDTO coffeeOrderDTO, BindingResult result, Model model) {

        ModelAndView view = new ModelAndView();
        orderValidator.validate(coffeeOrderDTO, result);

        if(result.hasErrors()){
            view.setViewName("definition-orderlist");
            model.addAttribute("coffeeOrderDTO", coffeeOrderDTO);
            model.addAttribute("error", result.getAllErrors().get(0).getDefaultMessage());
        } else {
            view.setViewName("definition-confirmation");
            coffeeOrderItemManager.addCoffeeOrderItem(coffeeOrderDTO);
        }
        return view;
    }

    @RequestMapping(value = "message", method = RequestMethod.GET)
    public ResponseEntity<String> getMessage(@RequestParam("code") String code){
        return new ResponseEntity<>(baseValidator.getMessage(code), HttpStatus.OK);
    }
}
