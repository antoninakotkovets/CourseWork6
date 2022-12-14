package com.example.coursework6.service;

import com.example.coursework6.model.Role;
import com.example.coursework6.model.User;
import com.example.coursework6.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public boolean saveUser(User user) {
       User foundUser = usersRepository.findByLogin(user.getLogin());
       if (foundUser != null) {
           return false;
       }
        user.setRole(Role.USER);
        usersRepository.save(user);
        return true;
    }
    @Override
    public boolean saveLibrarian(User user) {
        User foundUser = usersRepository.findByLogin(user.getLogin());
        if (foundUser != null) {
            return false;
        }
        user.setRole(Role.LIBRARIAN);
        usersRepository.save(user);
        return true;
    }

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll().stream()
                .filter(e -> e.getRole().equals(Role.ADMIN) || e.getRole().equals(Role.LIBRARIAN))
                .collect(Collectors.toList());
    }

    @Override
    public boolean recover(User users) {
        User user = usersRepository.findByLogin(users.getLogin());
        if (user.getSecretCode().equals(users.getSecretCode())) {
            users.setId(user.getId());
            users.setRole(user.getRole());
            usersRepository.save(users);
            return true;
        }

        return false;
    }


    @Override
    public Object login(User user) {
        User byId = usersRepository.findByLoginAndPassword(user.getLogin(), user.getPassword());
        return byId != null && !byId.isDeleted() ? byId : null;
    }

    @Override
    public void roleHandler(Integer id) {
        User user = usersRepository.findById(id).get();
        user.setRole(Role.ADMIN);

        usersRepository.save(user);
    }
    @Override
    public boolean deleteUser(Integer id){
        User user = usersRepository.findById(id).get();
        user.setDeleted(true);
        usersRepository.save(user);
        return true;
    }
}

