package com.salesianostriana.dam.validacion.anotaciones;

import com.salesianostriana.dam.validacion.validadores.UniqueNameValidator;
import com.salesianostriana.dam.validacion.validadores.UniqueRouteValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = UniqueRouteValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UniqueRoute {

    String message() default "el nombre no es unico";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};

}
