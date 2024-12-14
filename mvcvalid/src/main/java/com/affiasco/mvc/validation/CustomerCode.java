package com.affiasco.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Constraint(validatedBy = CustomerCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomerCode {

    public String value() default "AFF";

    public String message() default "must start with AFF";

    public Class<?>[] groups() default {};

    public Class<? extends Payload[]>[] payload() default {};

}
