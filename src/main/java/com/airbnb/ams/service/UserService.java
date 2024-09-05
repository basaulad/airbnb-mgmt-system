package com.airbnb.ams.service;


import com.airbnb.ams.entity.User;
import com.airbnb.ams.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //CRUD operations
    public String saveUser(User user){
        User savedUser = this.userRepository.save(user);
        if (savedUser != null){
            return "success";
        }else {
            return "failed";
        }
    }

    public User checkValidUser(User user) {
        System.out.println(user);
        User validatedUser = this.userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
        System.out.println(validatedUser);
        if(validatedUser != null){
            return validatedUser;
        }
        return user;
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(Long id, User userDetails) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setFullname(userDetails.getFullname());
                    user.setEmail(userDetails.getEmail());
                    user.setPassword(userDetails.getPassword());
                    return userRepository.save(user);
                }).orElse(null);
    }

    public String deleteUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            userRepository.deleteById(id);
            return "User having "+id+ " deleted successfully";
        }//else
        return "User having id "+id+ " not found.";
    }
}
