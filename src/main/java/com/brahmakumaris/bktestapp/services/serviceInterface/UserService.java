package com.brahmakumaris.bktestapp.services.serviceInterface;

import com.brahmakumaris.bktestapp.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    void deleteUser(Long id);
    User findByUserName(String userName);
}
