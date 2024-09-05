package com.airbnb.ams.controller;

import com.airbnb.ams.entity.User;
import com.airbnb.ams.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // URL: http://localhost:8081/users
    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody User user){
        return ResponseEntity.ok(this.userService.saveUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<User> checkValidUser(@RequestBody User user){
        return ResponseEntity.ok(this.userService.checkValidUser(user));
    }

    // URL: http://localhost:8081/users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    // URL: http://localhost:8081/users
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(this.userService.getUserById(id));
    }

    // URL: http://localhost:8081/users
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.ok(this.userService.updateUser(id, user));
    }

    // URL: http://localhost:8081/users
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        String result = userService.deleteUser(id);
        return ResponseEntity.ok(result);
    }
}
