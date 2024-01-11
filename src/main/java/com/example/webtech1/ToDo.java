package com.example.webtech1;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String taetigkeit;
    private Boolean erledigt;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserBody userBody;

    public ToDo() {}

    public ToDo(String taetigkeit, Boolean erledigt) {
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

    public Boolean getErledigt() {
        return erledigt;
    }

    public void setErledigt(Boolean erledigt) {
        this.erledigt = erledigt;
    }

    public UserBody getUserBody() {
        return userBody;
    }

    public void setUserBody(UserBody userBody) {
        this.userBody = userBody;
    }


}
