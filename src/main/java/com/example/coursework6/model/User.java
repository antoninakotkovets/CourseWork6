package com.example.coursework6.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User extends IdField {
    private String login;
    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role;
    private String secretCode;

    @Column(name = "is_deleted", columnDefinition = "bit default 0")
    private boolean isDeleted;
}


