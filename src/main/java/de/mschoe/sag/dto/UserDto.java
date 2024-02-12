package de.mschoe.sag.dto;

import de.mschoe.sag.validation.email.UniqueEmail;
import de.mschoe.sag.validation.user.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    @NotEmpty
    @UniqueUsername
    private String username;
    @Email
    @NotEmpty
    @UniqueEmail
    private String email;
    @Length(min = 8, max = 64)
    private String password;
}
