package br.edu.ifpr.cars.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;

public class SemPalavrasOfensivasValidation implements ConstraintValidator<SemPalavrasOfensivas, String> {

    private final List<String> proibidas = List.of("burro", "idiota", "lixo");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) return true; // comentário vazio é permitido
        String lower = value.toLowerCase();
        return proibidas.stream().noneMatch(lower::contains);
    }
}
