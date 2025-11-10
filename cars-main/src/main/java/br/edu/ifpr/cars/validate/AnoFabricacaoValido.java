package br.edu.ifpr.cars.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AnoFabricacaoValidoValidation.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface AnoFabricacaoValido {
    String message() default "Ano de fabricação inválido. Deve ser entre 1886 e o ano atual.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
