package de.mschoe.sag.validation.email;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = EmailValidator.class)
@Target(FIELD)
@Retention(RUNTIME)
public @interface UniqueEmail {
    String message() default "email not unique";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
