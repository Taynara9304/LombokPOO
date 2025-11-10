package br.edu.ifpr.cars.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PlacaValidaValidation.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PlacaValida {
    String message() default "Placa inválida. Use o formato Mercosul (ex: ABC1D23).";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
