package com.example.webtech1;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class UserBody {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;

    @JsonManagedReference
    @OneToMany(mappedBy = "userBody", fetch = FetchType.EAGER)
    private List<ToDo> todos;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ToDo> getTodos() {
        return todos;
    }

    public void setTodos(List<ToDo> todos) {
        this.todos = todos;
    }
}