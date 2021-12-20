package com.salesianos.triana.dam.TrianaTourist.validacion.anotaciones;

import com.salesianos.triana.dam.TrianaTourist.validacion.validadores.UniqueNameValidatorCategory;
import com.salesianos.triana.dam.TrianaTourist.validacion.validadores.UniqueNameValidatorRoute;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueNameValidatorRoute.class)
@Documented
public @interface UniqueNameRoute {
    String message() default "El nombre de la ruta debe ser unico";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
