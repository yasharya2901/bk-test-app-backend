package com.brahmakumaris.bktestapp.services.mySQLService;

import com.brahmakumaris.bktestapp.dtos.User.UserCreationDTO;
import com.brahmakumaris.bktestapp.dtos.User.UserDTO;
import com.brahmakumaris.bktestapp.models.Result;
import com.brahmakumaris.bktestapp.models.Test.Test;
import com.brahmakumaris.bktestapp.models.Test.TestState;
import com.brahmakumaris.bktestapp.models.User;
import com.brahmakumaris.bktestapp.repositories.TestRepository;
import com.brahmakumaris.bktestapp.repositories.UserRepository;
import com.brahmakumaris.bktestapp.services.serviceInterface.BatchService;
import com.brahmakumaris.bktestapp.services.serviceInterface.ResultService;
import com.brahmakumaris.bktestapp.services.serviceInterface.TestService;
import com.brahmakumaris.bktestapp.services.serviceInterface.UserService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private TestService testService;
    private ResultService resultService;
    private BatchService batchService;

    public UserServiceImpl(UserRepository userRepository, TestService testService, ResultService resultService, BatchService batchService){
        this.userRepository = userRepository;
        this.testService = testService;
        this.resultService = resultService;
        this.batchService = batchService;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = new LinkedList<>();
        for (User user : users) {
            userDTOs.add(convertUserToUserDTO(user));
        }
        return userDTOs;
    }

    @Override
    public UserDTO getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            // TODO: throw exception
        }

        UserDTO userDTO = convertUserToUserDTO(user.get());
        return userDTO;
    }

    private UserDTO convertUserToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setUserName(user.getUserName());
        userDTO.setMobNo(user.getMobNo());
        userDTO.setEmail(user.getEmail());
        userDTO.setAddress(user.getAddress());
        userDTO.setTestStates(user.getTestStates());
        userDTO.setBatchId(user.getBatch().getBatchId());
        userDTO.setBatchName(user.getBatch().getBatchName());
        return userDTO;
    }

    @Override
    public UserDTO createUser(UserCreationDTO userDTO) {
        User user = convertUserDTOToUser(userDTO);
        User returnUser = userRepository.save(user);
        return convertUserToUserDTO(returnUser);
    }

    private User convertUserDTOToUser(UserCreationDTO userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setMobNo(userDTO.getMobNo());
        user.setEmail(userDTO.getEmail());
        user.setAddress(userDTO.getAddress());
        user.setIsActive(userDTO.getIsActive());

        // setting test states
        Map<Long, TestState> maps = userDTO.getTestStates();
        Map<Test, TestState> testStates = new HashMap<>();
        if (maps != null && !maps.isEmpty()) {
            for (Long testId : maps.keySet()) {
                Test test = testService.getTestById(testId);
                testStates.put(test, maps.get(testId));
            }
            user.setTestStates(testStates);
        }
        // setting results
        List<Result> results = new LinkedList<>();
        List<Long> resultIds = userDTO.getResultIds();
        if (resultIds != null && !resultIds.isEmpty()) {
            for (Long resultId : resultIds) {
                results.add(resultService.getResultById(resultId));
            }
            user.setResults(results);
        }
        // setting batch
        if (userDTO.getBatchId() != null) {
            user.setBatch(batchService.getBatchById(userDTO.getBatchId()));
        }
        user.setUserType(userDTO.getUserType());
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO findByUserName(String userName) {
        Optional<User> user = userRepository.findByUserName(userName);
        if (user.isEmpty()) {
            // TODO: throw exception
        }
        return convertUserToUserDTO(user.get());
    }
}
