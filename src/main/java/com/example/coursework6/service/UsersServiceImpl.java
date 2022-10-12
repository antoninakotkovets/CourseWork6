package com.example.coursework6.service;

import com.example.coursework6.model.Users;
import com.example.coursework6.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public boolean saveUsers(Users users) {

        users.setRole("User");
        usersRepository.save(users);
        return true;
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }
}
