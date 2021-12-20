package com.salesianos.triana.dam.TrianaTourist.validacion.anotaciones;

import com.salesianos.triana.dam.TrianaTourist.validacion.validadores.UniquePoiValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniquePoiValidator.class)
@Documented
public @interface UniquePoi {
    String message() default "El punto de interes ya existe";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
