package com.example.SchoolProject.service;

import com.example.SchoolProject.entity.User;
import com.example.SchoolProject.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String saveUser(User user) {
        User savedUser = this.userRepository.save(user);
        if (savedUser != null) {
            return "User saved succesfully!";
        } else {
            return "User not saved!";
        }
    }

    public User checkValidUser(User user) {
        return this.userRepository.findUserByUserNameAndPassword(user.getUserName(), user.getPassword());
    }
}
