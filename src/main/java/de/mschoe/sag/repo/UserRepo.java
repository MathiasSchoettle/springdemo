package de.mschoe.sag.repo;

import de.mschoe.sag.models.User;
import jakarta.validation.constraints.Email;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepo extends ListCrudRepository<User, UUID> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
