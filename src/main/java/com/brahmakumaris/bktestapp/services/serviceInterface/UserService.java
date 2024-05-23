package com.brahmakumaris.bktestapp.services.serviceInterface;

import com.brahmakumaris.bktestapp.dtos.User.UserCreationDTO;
import com.brahmakumaris.bktestapp.dtos.User.UserDTO;
import com.brahmakumaris.bktestapp.models.User;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO createUser(UserCreationDTO user);
    void deleteUser(Long id);
    UserDTO findByUserName(String userName);
}
