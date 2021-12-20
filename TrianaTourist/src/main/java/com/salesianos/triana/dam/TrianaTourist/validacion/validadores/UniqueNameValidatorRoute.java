package com.salesianos.triana.dam.TrianaTourist.validacion.validadores;

import com.salesianos.triana.dam.TrianaTourist.service.RouteService;
import com.salesianos.triana.dam.TrianaTourist.validacion.anotaciones.UniqueNameCategory;
import com.salesianos.triana.dam.TrianaTourist.validacion.anotaciones.UniqueNameRoute;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniqueNameValidatorRoute implements ConstraintValidator<UniqueNameRoute, String> {

    private final RouteService service;

    @Override
    public void initialize(UniqueNameRoute constraintAnnotation) { }

    @Override
    public boolean isValid(String nombre, ConstraintValidatorContext context) {
        return StringUtils.hasText(nombre) && !service.comprobarName(nombre);
    }
}
