package br.edu.ifpr.cars.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class AnoFabricacaoValidoValidation implements ConstraintValidator<AnoFabricacaoValido, Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) return false;
        int currentYear = LocalDate.now().getYear();
        return value >= 1886 && value <= currentYear;
    }
}
