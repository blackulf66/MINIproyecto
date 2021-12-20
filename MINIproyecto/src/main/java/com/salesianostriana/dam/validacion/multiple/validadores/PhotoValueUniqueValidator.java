package com.salesianostriana.dam.validacion.multiple.validadores;

import com.salesianostriana.dam.validacion.multiple.anotaciones.PhotoValueUnique;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhotoValueUniqueValidator implements ConstraintValidator<PhotoValueUnique, Object> {
    
    @Override
    public void initialize(PhotoValueUnique constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
