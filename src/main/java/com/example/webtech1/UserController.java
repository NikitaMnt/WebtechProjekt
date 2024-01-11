package com.example.webtech1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserBodyRepository userRepository;

    @Autowired
    private ToDoRepository todoRepository;

    @PostMapping
    public UserBody createUser(@RequestBody UserBody user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<UserBody> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public UserBody getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public UserBody updateUser(@PathVariable Long id, @RequestBody UserBody userDetails) {
        return userService.updateUser(id, userDetails);
    }

    @PostMapping("/login")
    public ResponseEntity<UserBody> loginUser(@RequestBody UserBody user) {
        UserBody existingUser = userService.getUserByUsername(user.getUsername());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return new ResponseEntity<>(existingUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/{username}/todos")
    public List<ToDo> getUserTodos(@PathVariable String username) {
        UserBody user = userRepository.findByUsername(username);
        if (user == null) {
            throw new ResourceNotFoundException("User", "id", 1);
        }
        return user.getTodos();
    }

    @PostMapping("/{username}/todos")
    public ToDo addUserTodo(@PathVariable String username, @RequestBody ToDo todo) {
        UserBody user = userRepository.findByUsername(username);
        if (user == null) {
            throw new ResourceNotFoundException("User", "id", 1);
        }
        todo.setUserBody(user);
        ToDo savedTodo = todoRepository.save(todo);
        return savedTodo;
    }
}