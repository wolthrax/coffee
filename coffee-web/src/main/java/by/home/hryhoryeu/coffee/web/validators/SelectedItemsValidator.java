package by.home.hryhoryeu.coffee.web.validators;

import by.home.hryhoryeu.coffee.dto.SelectedItemsDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SelectedItemsValidator extends BaseValidator implements Validator{

    public boolean supports(Class<?> clazz) {
        return SelectedItemsDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        SelectedItemsDTO selectedItems = (SelectedItemsDTO) object;

        if(!selectedItems.getQuantitySelectedItems().isEmpty()) {

            for (String value : selectedItems.getQuantitySelectedItems()) {
                if (!checkRegularExpressions("regexp.quantity", value)) {
                    errors.reject("error.quantity", getMessage("lang.error.incorrect.quantity"));
                }
            }
        } else  errors.reject("error.quantity", getMessage("lang.error.empty.quantity"));
    }
}
