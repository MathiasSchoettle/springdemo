package de.mschoe.sag.security;

import de.mschoe.sag.dto.UserDto;
import de.mschoe.sag.models.User;
import de.mschoe.sag.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("username not found"));
        return new CustomerUserDetails(user);
    }

    public void createNewUser(UserDto userDto) {
        // TODO also persist email
        var user = new User(userDto.getUsername(), userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()));
        userRepo.save(user);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void createUser() {
        createNewUser(new UserDto("admin", "admin@test.de", "admin"));
    }
}
