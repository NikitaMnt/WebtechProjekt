package com.example.webtech1;

import jakarta.persistence.*;

@Entity
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String taetigkeit;
    private String erledigt;

    public ToDo() {}

    public ToDo(String taetigkeit, String erledigt) {
        this.taetigkeit = taetigkeit;
        this.erledigt = erledigt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaetigkeit() {
        return taetigkeit;
    }

    public void setTaetigkeit(String taetigkeit) {
        this.taetigkeit = taetigkeit;
    }

    public String getErledigt() {
        return erledigt;
    }

    public void setErledigt(String erledigt) {
        this.erledigt = erledigt;
    }


}
