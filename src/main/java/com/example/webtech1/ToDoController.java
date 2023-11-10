package com.example.webtech1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {

    @Autowired
    ToDoService service;

    Logger logger = LoggerFactory.getLogger(ToDoController.class);

    @PostMapping("/todos")
    public ToDo createToDo(@RequestBody ToDo toDo) {
        return service.save(toDo);
    }

    @GetMapping("/todos/{id}")
    public ToDo getToDo(@PathVariable String id) {
        logger.info("GET request on route things with {}", id);
        Long thingId = Long.parseLong(id);
        return service.get(thingId);
    }

    @GetMapping("/todos")
    public List<ToDo> getAllToDos() {
        return service.getAll();
    }

}
