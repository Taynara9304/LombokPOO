package br.edu.ifpr.cars.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PlacaValidation implements ConstraintValidator<Placa, Integer> {
    
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value % 2 != 0;
    }
}
