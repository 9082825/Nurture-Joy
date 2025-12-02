package com.nurturejoy.NurtureJoy.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 80)
    private String fullName;

    @NotBlank
    @Size(min = 3, max = 30)
    @Column(unique = true)
    private String username;   // used for login

    @NotBlank
    @Size(min = 6)
    private String passwordHash;  // store hashed password

    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {}

    public User(String fullName, String username, String passwordHash, Role role) {
        this.fullName = fullName;
        this.username = username;
        this.passwordHash = passwordHash;
        this.role = role;
    }

    public Long getId() { return id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
}
