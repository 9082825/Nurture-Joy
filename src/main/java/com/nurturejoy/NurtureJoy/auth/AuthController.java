package com.nurturejoy.NurtureJoy.auth;

import com.nurturejoy.NurtureJoy.user.Role;
import com.nurturejoy.NurtureJoy.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";  // login.html
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("registrationForm", new RegistrationDto());
        model.addAttribute("roles", Role.values());
        return "register"; // register.html
    }

    @PostMapping("/register")
    public String handleRegistration(
            @ModelAttribute("registrationForm") RegistrationDto form,
            Model model
    ) {
        try {
            userService.registerNewUser(form);
        } catch (IllegalArgumentException ex) {
            model.addAttribute("registrationForm", form);
            model.addAttribute("roles", Role.values());
            model.addAttribute("errorMessage", ex.getMessage());
            return "register";   // stay on page, show error
        }

        // success → redirect to login with ?registered flag
        return "redirect:/login?registered";
    }
}
