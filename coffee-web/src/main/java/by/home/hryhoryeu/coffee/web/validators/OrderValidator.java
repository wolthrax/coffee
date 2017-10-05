package by.home.hryhoryeu.coffee.web.validators;

import by.home.hryhoryeu.coffee.dto.CoffeeOrderDTO;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class OrderValidator extends BaseValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return CoffeeOrderDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        CoffeeOrderDTO coffeeOrderDTO = (CoffeeOrderDTO) object;

        if(coffeeOrderDTO.getName() == null || coffeeOrderDTO.getName().isEmpty()){
            errors.reject("error.full_name", getMessage("lang.error.empty.full_name"));
        } else if(!checkRegularExpressions("regexp.full_name", coffeeOrderDTO.getName())){
            errors.reject("error.full_name", getMessage("lang.error.incorrect.full_name"));
        }

        if(coffeeOrderDTO.getAddress() == null || coffeeOrderDTO.getAddress().isEmpty()){
            errors.reject("error.address", getMessage("lang.error.empty.address"));
        } else if(!checkRegularExpressions("regexp.address", coffeeOrderDTO.getAddress())){
            errors.reject("error.address", getMessage("lang.error.incorrect.address"));
        }
    }
}
