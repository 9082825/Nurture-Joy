package com.nurturejoy.NurtureJoy.user;

import com.nurturejoy.NurtureJoy.auth.RegistrationDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerNewUser(RegistrationDto form) {

        if (form.getFullName() == null || form.getFullName().trim().length() < 2) {
            throw new IllegalArgumentException("Full name must have at least 2 characters.");
        }

        if (form.getUsername() == null || form.getUsername().trim().length() < 3) {
            throw new IllegalArgumentException("Username must have at least 3 characters.");
        }

        if (userRepository.existsByUsername(form.getUsername().trim())) {
            throw new IllegalArgumentException("Username is already taken.");
        }

        if (form.getPassword() == null || form.getPassword().length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long.");
        }

        if (!form.getPassword().equals(form.getConfirmPassword())) {
            throw new IllegalArgumentException("Passwords do not match.");
        }

        Role role = form.getRole() != null ? form.getRole() : Role.PATIENT;

        String hashed = passwordEncoder.encode(form.getPassword());

        User user = new User(
                form.getFullName().trim(),
                form.getUsername().trim(),
                hashed,
                role
        );

        userRepository.save(user);
    }
}
