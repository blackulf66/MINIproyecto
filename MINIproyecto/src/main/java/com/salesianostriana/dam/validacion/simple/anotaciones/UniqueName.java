package com.salesianostriana.dam.validacion.simple.anotaciones;

import com.salesianostriana.dam.validacion.simple.validadores.UniqueNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = UniqueNameValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UniqueName {

    String message() default "el nombre no es unico";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};



}
