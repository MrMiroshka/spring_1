package ru.miroshka.hw11.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.miroshka.hw11.data.User;
import ru.miroshka.hw11.servicies.UserService;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final UserService userService;

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/unsecured")
    public String useredPage() {
        return "unsecured";
    }

    @GetMapping("/auth_page")
    public String uathenticatedPage() {
        return "authenticated";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @GetMapping("/user_info")
    public String daoTestPage(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException(""));
        return "Authenticaated user info:" + user.getUserName() + " : " + user.getEmail();
    }
}
