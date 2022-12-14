package com.example.coursework6.service;

import com.example.coursework6.model.User;

import java.util.List;

public interface UsersService {
    boolean saveUser(User user);
    boolean saveLibrarian(User user);
    boolean recover(User user);
    void roleHandler(Integer id);
    List<User> getAllUsers();
    Object login(User user);
    boolean deleteUser(Integer id);

}
