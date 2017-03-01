package com.robertkoch.imperialassault.services.models;

import com.robertkoch.imperialassault.domain.enums.Role;
import com.robertkoch.imperialassault.domain.login.Login;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginModel {
    @NotNull
    private String username;

    @Size(min = 8)
    private String password;

    private Role role;

    public LoginModel() {
        role = Role.Standard;
    }

    public LoginModel(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = Role.Standard;
    }

    public LoginModel(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public LoginModel(Login login) {
        this.username = login.getUsername();
        this.password = login.getPassword();
        this.role = login.getRole();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
