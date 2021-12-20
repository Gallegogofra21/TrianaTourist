package com.salesianos.triana.dam.TrianaTourist.validacion.validadores;

import com.salesianos.triana.dam.TrianaTourist.service.CategoryService;
import com.salesianos.triana.dam.TrianaTourist.validacion.anotaciones.ExistsCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class ExistsCategoryValidator implements ConstraintValidator<ExistsCategory, Long> {

    @Autowired
    private final CategoryService service;

    @Override
    public void initialize(ExistsCategory constraintAnnotation) {
    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        return service.comprobarId(id) && id!= null;
    }
}
