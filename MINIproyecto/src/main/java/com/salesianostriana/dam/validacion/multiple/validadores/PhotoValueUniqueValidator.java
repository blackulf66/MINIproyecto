package com.salesianostriana.dam.validacion.multiple.validadores;

import com.salesianostriana.dam.validacion.multiple.anotaciones.PhotoValueUnique;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PhotoValueUniqueValidator implements ConstraintValidator<PhotoValueUnique, Object> {
    String coverPhoto;


    @Override
    public void initialize(PhotoValueUnique constraintAnnotation) {
        this.coverPhoto = constraintAnnotation.field() ;
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Object coverPhotoValue = PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(coverPhoto);
        if (coverPhotoValue != null){
            return Pattern.matches("(http)?s?:?(\\/\\/[^\"']*\\.(?:png|jpg|jpeg|gif|png|svg))", (CharSequence) coverPhotoValue);
        }else{
            return  coverPhotoValue==null;
        }
    }
}
