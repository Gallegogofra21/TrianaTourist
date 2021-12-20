package com.salesianos.triana.dam.TrianaTourist.validacion.validadores;

import com.salesianos.triana.dam.TrianaTourist.repo.RouteRepository;
import com.salesianos.triana.dam.TrianaTourist.validacion.anotaciones.UniquePoi;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniquePoiValidator implements ConstraintValidator<UniquePoi, Long> {

    private final RouteRepository repository;

    @Override
    public void initialize(UniquePoi constraintAnnotation) {
    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext constraintValidatorContext) {
        return repository.comprobarPOI(id)== null;
    }
}
