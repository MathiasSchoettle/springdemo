package de.mschoe.sag.validation.user;

import de.mschoe.sag.repo.UserRepo;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserRepo userRepo;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (userRepo.existsByUsername(value)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Username " + value + " is already taken")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
