package com.ankit.entity;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private boolean active;

    @ManyToOne
    @JoinColumn(name = "stateid", referencedColumnName = "id")
    private State stateid;

    @ManyToOne
    @JoinColumn(name = "countryid", referencedColumnName = "id")
    private Country countryid;

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

    public State getStateid() {
        return stateid;
    }

    public void setStateid(State stateid) {
        this.stateid = stateid;
    }

    public Country getCountryid() {
        return countryid;
    }

    public void setCountryid(Country countryid) {
        this.countryid = countryid;
    }
}
