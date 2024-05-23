package com.brahmakumaris.bktestapp.controllers;

import com.brahmakumaris.bktestapp.dtos.User.UserCreationDTO;
import com.brahmakumaris.bktestapp.dtos.User.UserDTO;
import com.brahmakumaris.bktestapp.models.User;
import com.brahmakumaris.bktestapp.services.serviceInterface.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test-app/v1/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserCreationDTO user) {
        return userService.createUser(user);
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
