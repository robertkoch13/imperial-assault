package com.robertkoch.imperialassault.domain.login;

import com.robertkoch.imperialassault.domain.common.IdentifiableEntity;
import com.robertkoch.imperialassault.domain.enums.Role;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by robert.koch on 2017/02/15.
 */
@Entity
@Table(name="login")
public class Login  extends IdentifiableEntity implements Serializable {
    public static final long serialVersionUID = 1L;

    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public Login() {
    }

    public Login(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
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
