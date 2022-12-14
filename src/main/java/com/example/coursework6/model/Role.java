package com.example.coursework6.model;

public enum Role {
    ADMIN("Админ"),
    USER("Пользователь"),
    LIBRARIAN("Библиотекарь");

    private String ruValue;

    Role(String ruValue) {
        this.ruValue = ruValue;
    }

    public String getRuValue() {
        return ruValue;
    }
}
