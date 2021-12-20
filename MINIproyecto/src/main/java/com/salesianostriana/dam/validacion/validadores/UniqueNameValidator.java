package com.salesianostriana.dam.validacion.validadores;

import com.salesianostriana.dam.repositorios.CategoryRepositorio;
import com.salesianostriana.dam.validacion.anotaciones.UniqueName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameValidator implements ConstraintValidator<UniqueName , String> {

    @Autowired
    private CategoryRepositorio rep;

    @Override
    public void initialize(UniqueName constraintAnnotation) {
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return StringUtils.hasText(name) && !rep.existsByName(name);
    }

}
