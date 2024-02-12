package de.mschoe.sag.validation.user;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = UsernameValidator.class)
@Target(FIELD)
@Retention(RUNTIME)
public @interface UniqueUsername {
    String message() default "username not unique";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
