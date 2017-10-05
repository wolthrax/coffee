package by.home.hryhoryeu.coffee.web.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@PropertySource(value = {"classpath:/regexp.properties"})
public class BaseValidator {

    @Autowired
    private Environment environment;

    @Autowired
    private MessageSource messageSource;

    protected final boolean checkRegularExpressions(String patternString, Object object) {

        String matcherString = object.toString();

        Pattern pattern = Pattern.compile(environment.getRequiredProperty(patternString));
        Matcher matcher = pattern.matcher(matcherString);
        return matcher.matches();
    }

    public final String getMessage(String code){
        try {
            return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
        } catch (NoSuchMessageException e){
            return "default error";
        }
    }
}
