package com.book.Book.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PriceImpl.class})
public @interface Price {
    String message() default "{validation.constraints.price}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
