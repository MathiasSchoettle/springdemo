package de.mschoe.sag.controller;

import de.mschoe.sag.models.User;
import de.mschoe.sag.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepo userRepo;

    @ModelAttribute("users")
    public List<User> allUsers() {
        return userRepo.findAll();
    }

    @GetMapping("users")
    public String users() {
        return "users";
    }
}
