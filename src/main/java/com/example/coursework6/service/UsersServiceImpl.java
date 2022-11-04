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
        List<Users> found = usersRepository.findAll();
        for (int i = 0; i < found.size(); i++) {
            if (users.getLogin().equals(found.get(i).getLogin())) {
                return false;
            }
        }
        users.setRole("user");
        usersRepository.save(users);
        return true;
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public boolean recover(Users users) {
        Users user = usersRepository.findByLogin(users.getLogin());
        if (user.getSecretCode().equals(users.getSecretCode())) {
            users.setId(user.getId());
            users.setRole(user.getRole());
            usersRepository.save(users);
            return true;
        }

        return false;
    }


    @Override
    public Object login(Users users) {
        List<Users> found = usersRepository.findAll();
        for (int i = 0; i < found.size(); i++) {
            if (found.get(i).getLogin().equals(users.getLogin()) && found.get(i).getPassword().equals(users.getPassword())) {
                return found.get(i);
            }
        }

        return false;
    }
}

