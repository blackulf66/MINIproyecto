package com.salesianostriana.dam.validacion.multiple.anotaciones;

import com.salesianostriana.dam.validacion.multiple.validadores.FieldsValueMatchValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = FieldsValueMatchValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface PhotoValueUnique {


    String message() default "la url no es valida";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String field();

    @Target({ElementType.TYPE, ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List{
        PhotoValueUnique[] value();
    }
}