package com.ankit.entity;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class Country {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private boolean active;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
