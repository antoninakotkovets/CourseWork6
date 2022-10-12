package com.example.coursework6.service;

import com.example.coursework6.model.Users;

import java.util.List;

public interface UsersService {
    public boolean saveUsers(Users users);
    public List<Users> getAllUsers();
}
