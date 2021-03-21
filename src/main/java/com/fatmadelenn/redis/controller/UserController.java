package com.fatmadelenn.redis.controller;

import com.fatmadelenn.redis.model.User;
import com.fatmadelenn.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class UserController {

    @Autowired
    private UserService userService;

    @Cacheable(value = "users")
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Cacheable(value = "users", key = "#name")
    @GetMapping("/users/{name}")
    public User getUserWithName(@PathVariable String name) throws Exception {
        return userService.getUserWithName(name);
    }

    @CacheEvict(value = "users", key = "#name")
    @DeleteMapping("/users/{name}")
    public void deleteUserWithName(@PathVariable String name){
        userService.deleteUserWithName(name);
    }

    @CacheEvict(value = "users", allEntries = true)
    @DeleteMapping("/users/delete-all")
    public void deleteAllUsers() {
        userService.deleteAllUsers();
    }

    @CachePut(value = "users", key = "#userDTO.name")
    @PutMapping("/users/update")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
}
