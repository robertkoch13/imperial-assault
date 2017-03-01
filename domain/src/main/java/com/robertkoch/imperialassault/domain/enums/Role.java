package com.robertkoch.imperialassault.domain.enums;

/**
 * Created by robert.koch on 2017/02/15.
 */
public enum Role {
    Standard("Standard"), Admin("Admin");

    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return role;
    }
}
