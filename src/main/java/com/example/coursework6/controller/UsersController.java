package com.example.coursework6.controller;

import com.example.coursework6.model.User;
import com.example.coursework6.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/add")
    public boolean add(@RequestBody User user){
        return usersService.saveUser(user);

    }

    @PutMapping("/recover")
    public boolean recover(@RequestBody User user) {
        return usersService.recover(user);
    }

    @PostMapping("/login")
    public Object login(@RequestBody User user){
        return usersService.login(user);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return usersService.getAllUsers().stream().filter(u -> !u.isDeleted()).collect(Collectors.toList());
    }

    @PutMapping("/handler/role/{id}")
    public boolean roleHandler(@PathVariable Integer id) {
        usersService.roleHandler(id);
        return true;
    }

    @PostMapping("/registerLib")
    public boolean addLibrarian(@RequestBody User user){
        return usersService.saveLibrarian(user);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteUser(@PathVariable Integer id) {
       return usersService.deleteUser(id);
    }


}
