package com.example.webtech1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserBodyRepository userRepository;

    public UserService(UserBodyRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserBody createUser(UserBody user) {
        return userRepository.save(user);
    }

    public List<UserBody> getUsers() {
        return userRepository.findAll();
    }

    public UserBody getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }

    public UserBody updateUser(Long id, UserBody userDetails) {
        UserBody user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setEmail(userDetails.getEmail());

        return userRepository.save(user);
    }

    public UserBody getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public UserBody getUserWithTodos(Long id) {
        UserBody user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        user.getTodos().size(); // This will initialize the todos collection
        return user;
    }

}