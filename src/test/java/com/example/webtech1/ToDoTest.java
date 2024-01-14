package com.example.webtech1;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ToDoTest {
    private ToDo toDo;

    @BeforeEach
    void setUp() {
        toDo = new ToDo();
    }

    @Test
    void testId() {
        Long idValue = 1L;
        toDo.setId(idValue);
        assertEquals(idValue, toDo.getId());
    }

    @Test
    void testTaetigkeit() {
        String taetigkeitValue = "Test Taetigkeit";
        toDo.setTaetigkeit(taetigkeitValue);
        assertEquals(taetigkeitValue, toDo.getTaetigkeit());
    }

    @Test
    void testErledigt() {
        Boolean erledigtValue = true;
        toDo.setErledigt(erledigtValue);
        assertEquals(erledigtValue, toDo.getErledigt());
    }

}