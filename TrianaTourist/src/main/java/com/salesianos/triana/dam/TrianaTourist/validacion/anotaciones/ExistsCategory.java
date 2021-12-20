package com.salesianos.triana.dam.TrianaTourist.validacion.anotaciones;

import com.salesianos.triana.dam.TrianaTourist.validacion.validadores.ExistsCategoryValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExistsCategoryValidator.class)
@Documented
public @interface ExistsCategory {

    String message() default "No se pueden repetir dos categorias iguales";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
