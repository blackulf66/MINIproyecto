package com.salesianostriana.dam.validacion.validadores;


import com.salesianostriana.dam.repositorios.RouteRepositorio;
import com.salesianostriana.dam.validacion.anotaciones.UniquePOI;
import com.salesianostriana.dam.validacion.anotaciones.UniqueRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniquePOIValidator implements ConstraintValidator<UniquePOI, String> {

    @Autowired
    private RouteRepositorio rep;

    @Override
    public void initialize(UniquePOI constraintAnnotation) {
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return StringUtils.hasText(name) && !rep.existsByName(name);
    }

}
