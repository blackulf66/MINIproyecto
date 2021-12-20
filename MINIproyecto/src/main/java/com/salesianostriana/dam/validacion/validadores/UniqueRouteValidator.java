package com.salesianostriana.dam.validacion.validadores;

import com.salesianostriana.dam.repositorios.CategoryRepositorio;
import com.salesianostriana.dam.repositorios.RouteRepositorio;
import com.salesianostriana.dam.validacion.anotaciones.UniqueName;
import com.salesianostriana.dam.validacion.anotaciones.UniqueRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueRouteValidator implements ConstraintValidator<UniqueRoute, String> {

    @Autowired
    private RouteRepositorio rep;

    @Override
    public void initialize(UniqueRoute constraintAnnotation) {
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return StringUtils.hasText(name) && !rep.existsByName(name);
    }

}
