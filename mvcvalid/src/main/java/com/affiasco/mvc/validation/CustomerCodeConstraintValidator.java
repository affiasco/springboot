package com.affiasco.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomerCodeConstraintValidator implements ConstraintValidator<CustomerCode, String> {

    private String customerPrefix;

    @Override
    public void initialize(CustomerCode theCustomerCode) {
        customerPrefix = theCustomerCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext context) {

        boolean result;

        if (theCode != null) {
            result = theCode.startsWith(customerPrefix);
        } else {
            result = true;
        }

        return result;
    }
}
