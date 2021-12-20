package com.salesianos.triana.dam.TrianaTourist.validacion.anotaciones;

import com.salesianos.triana.dam.TrianaTourist.validacion.validadores.UniqueNameValidatorCategory;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueNameValidatorCategory.class)
@Documented
public @interface UniqueNameCategory {
        String message() default "El nombre de la categoria debe ser único";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};
}
