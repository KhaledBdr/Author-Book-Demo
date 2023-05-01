package com.book.Book.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PriceImpl implements ConstraintValidator<Price, Double> {
    @Override
    public boolean isValid(Double value, ConstraintValidatorContext constraintValidatorContext) {
        if (value > 10) return true;
        return false;
    }
}
