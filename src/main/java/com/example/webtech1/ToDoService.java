package com.example.webtech1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {

    @Autowired
    ToDoRepository repo;

    public ToDo save(ToDo toDo) {
        return repo.save(toDo);
    }

    public ToDo get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<ToDo> getAll() {
        Iterable<ToDo> iterator = repo.findAll();
        List<ToDo> toDos = new ArrayList<ToDo>();
        for (ToDo toDo : iterator)  toDos.add(toDo);
        return toDos;
    }
}
