package com.salesianos.triana.dam.TrianaTourist.validacion.validadores;

import com.salesianos.triana.dam.TrianaTourist.service.CategoryService;
import com.salesianos.triana.dam.TrianaTourist.validacion.anotaciones.UniqueNameCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniqueNameValidatorCategory implements ConstraintValidator<UniqueNameCategory, String> {


    private final CategoryService service;

    @Override
    public void initialize(UniqueNameCategory constraintAnnotation) { }

    @Override
    public boolean isValid(String nombre, ConstraintValidatorContext context) {
        return StringUtils.hasText(nombre) && !service.comprobarName(nombre);
    }
}
