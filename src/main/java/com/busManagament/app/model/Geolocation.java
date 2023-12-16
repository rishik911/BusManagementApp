package com.busManagament.app.model;

import lombok.*;
import org.springframework.data.annotation.Id;

public class Geolocation {

    @Id
    private String id;

    private String name;

    public Geolocation(String name){
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
