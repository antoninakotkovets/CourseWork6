package com.example.coursework6.controller;

import com.example.coursework6.model.Users;
import com.example.coursework6.service.UsersService;
import com.example.coursework6.service.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/add")
    public boolean add(@RequestBody Users users){
        return usersService.saveUsers(users);

    }

    @PutMapping("/recover")
    public boolean recover(@RequestBody Users users) {
        return usersService.recover(users);
    }

    @PostMapping("/login")
    public Object login(@RequestBody Users users){
        return usersService.login(users);
    }
    @GetMapping("/getAll")
    public List<Users> getAllUsers(){
        return usersService.getAllUsers();
    }


}
