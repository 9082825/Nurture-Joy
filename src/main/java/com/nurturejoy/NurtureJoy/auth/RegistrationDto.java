package com.nurturejoy.NurtureJoy.auth;

import com.nurturejoy.NurtureJoy.user.Role;

public class RegistrationDto {

    private String fullName;
    private String username;
    private String password;
    private String confirmPassword;
    private Role role;

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getConfirmPassword() { return confirmPassword; }
    public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
}
