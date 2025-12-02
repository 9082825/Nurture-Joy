package com.nurturejoy.NurtureJoy.config;

import com.nurturejoy.NurtureJoy.user.CustomUserDetailsService;
import com.nurturejoy.NurtureJoy.user.UserRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // Password encoder for both registration & login
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Authentication provider using our CustomUserDetailsService directly
    @Bean
    public AuthenticationProvider authenticationProvider(UserRepository userRepository,
                                                         PasswordEncoder passwordEncoder) {

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(new CustomUserDetailsService(userRepository));
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,
                                       AuthenticationProvider authProvider) throws Exception {

        http
            .authenticationProvider(authProvider)
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/", "/login", "/register", "/css/**", "/images/**", "/h2-console/**").permitAll()
                    .anyRequest().authenticated()
            )
            .formLogin(form -> form
                    .loginPage("/login")
                    .defaultSuccessUrl("/", true)   // <---
                    .failureUrl("/login?error")
                    .permitAll()
            )
            .logout(logout -> logout.permitAll())
            .csrf(csrf -> csrf.disable())
            .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin())); // REQUIRED

        return http.build();
    }
}
