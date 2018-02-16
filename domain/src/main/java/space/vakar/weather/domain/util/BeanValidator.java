package space.vakar.weather.domain.util;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import space.vakar.weather.domain.model.Weather;

public class BeanValidator {	
    
    public static Set<ConstraintViolation<Weather>> validate(Weather weather) {
    	return defaultValidator().validate(weather);    	
    }
    
    private static Validator defaultValidator() {
    	return defaultValidatorFactory().getValidator();
    }
    
    private static ValidatorFactory defaultValidatorFactory() {
    	return Validation.buildDefaultValidatorFactory();
    }
}
