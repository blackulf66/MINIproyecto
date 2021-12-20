package com.salesianostriana.dam.validacion.anotaciones;

import com.salesianostriana.dam.validacion.validadores.UniqueNameValidator;

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
