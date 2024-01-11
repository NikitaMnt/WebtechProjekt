package com.example.webtech1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.List;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class ToDoController {

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/todos/**") // Passe den Pfad entsprechend deiner API-Routen an
                .allowedOrigins("http://localhost:PORT") // Erlaube Anfragen von diesem Ursprung (ersetze PORT durch deinen Frontend-Port)
                .allowedMethods("GET", "POST", "PUT", "DELETE"); // Erlaubte HTTP-Methoden
    }

    @Autowired
    ToDoService service;
    @Autowired
    private UserBodyRepository userRepository;
    @Autowired
    private ToDoRepository todoRepository;

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


    @DeleteMapping("/users/{username}/todos/{id}")
    public void deleteToDo(@PathVariable long id) {
        ToDo todo = service.get(id);
        service.delete(todo);
    }

    @PutMapping("/todos/{id}")
    public ToDo updateToDo(@PathVariable long id, @RequestBody ToDo updatedToDo){
        ToDo existingToDo = service.get(id);
        existingToDo.setTaetigkeit(updatedToDo.getTaetigkeit());
        existingToDo.setErledigt(updatedToDo.getErledigt());
        return service.save(existingToDo);
    }

}
