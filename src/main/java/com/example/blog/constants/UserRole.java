package com.example.blog.constants;

public enum UserRole {
    USER(10),
    ADMIN(11);

    private int code;

    private UserRole(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
