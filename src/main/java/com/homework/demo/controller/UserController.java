package com.homework.demo.controller;

import com.homework.demo.model.User;
import com.homework.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User newUser) throws Exception{
        User usr=userService.getUserById(id);
        usr.setId(newUser.getId());
        usr.setName(newUser.getName());
        usr.setLastName(newUser.getLastName());
        usr.setMobile(newUser.getMobile());
        return ResponseEntity.ok(userService.updateUserById(usr));
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.deleteUserById(userService.getUserById(id).getId());
        return "User with ID :"+id+" is deleted";
    }
}