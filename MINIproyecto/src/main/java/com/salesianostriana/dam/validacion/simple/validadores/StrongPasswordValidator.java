package com.salesianostriana.dam.validacion.simple.validadores;


import com.salesianostriana.dam.validacion.simple.anotaciones.StrongPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StrongPasswordValidator implements ConstraintValidator<StrongPassword, String> {

    private int min;
    private int max;
    private boolean hasUpper;
    private boolean hasLower;
    private boolean hasNumber;
    private boolean hasAlpha;
    private boolean hasOthers;

    @Override
    public void initialize(StrongPassword constraintAnnotation) {
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
        hasUpper = constraintAnnotation.hasUpper();
        hasLower = constraintAnnotation.hasLower();
        hasNumber = constraintAnnotation.hasNumber();
        hasAlpha = constraintAnnotation.hasAlpha();
        hasOthers = constraintAnnotation.hasOthers();
    }
    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if(password.length()>max|| password.length()<min) {
            return false;
        }
        if(hasUpper){
            if(password.equals(password.toLowerCase())){
                return false;
            };
        }
        if(hasLower){
            if(password.equals(password.toUpperCase())){
                return false;
            }
        }
        if(hasNumber){
            if(!password.matches(".*\\d.*"))
                return false;
        }
        if(hasAlpha){
            if(!password.matches(".*[a-z].*")){
                return false;
            }
        }
        if(hasOthers){
            if(!(password.contains(".") || password.contains(",") || password.contains("$")
            || password.contains("-") || password.contains("_"))){
                return false;
            }
        }
        return true;
    }
}
