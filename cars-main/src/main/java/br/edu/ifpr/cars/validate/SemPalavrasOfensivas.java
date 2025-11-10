package br.edu.ifpr.cars.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SemPalavrasOfensivasValidation.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface SemPalavrasOfensivas {
    String message() default "O comentário contém palavras ofensivas.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
