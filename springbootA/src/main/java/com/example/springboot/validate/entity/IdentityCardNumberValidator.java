package com.example.springboot.validate.entity;

import com.example.springboot.validate.definedInterface.IdentityCardNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdentityCardNumberValidator implements ConstraintValidator<IdentityCardNumber,Object> {
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if(o.toString().length()==18){
            return true;
        }
        return false;
    }
}
