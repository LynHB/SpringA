package com.example.springboot.validate.definedInterface;

import com.example.springboot.validate.entity.IdentityCardNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IdentityCardNumberValidator.class)
public @interface IdentityCardNumber {
    String message() default "身份证不合法";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
