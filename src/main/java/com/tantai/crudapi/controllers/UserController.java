package com.tantai.crudapi.controllers;

import com.tantai.crudapi.entity.User;
import com.tantai.crudapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        user.setId(0);
        return userService.save(user);
    }

    @GetMapping("/users")
    public List<User> getAllUser(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @DeleteMapping("users/{id}")
    public Optional<User> deleteUserbyId(@PathVariable Integer id){
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            userService.deleteUserById(id);
            return user;
        }
        else{
            return null;
        }
    }

    @PutMapping("/users")
    public User updateUserById(@RequestBody User user){
        return userService.save(user);
    }
}
