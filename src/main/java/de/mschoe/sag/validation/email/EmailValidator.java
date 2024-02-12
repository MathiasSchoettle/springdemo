package de.mschoe.sag.validation.email;

import de.mschoe.sag.repo.UserRepo;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final UserRepo userRepo;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (userRepo.existsByEmail(value)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Email " + value + " is already taken")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
