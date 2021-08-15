package ru.birdnest.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table()
public class Bird {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "coolor")
    private String coolor;
    @Column(name = "fly")
    private boolean fly;

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

    public String getCoolor() {
        return coolor;
    }

    public void setCoolor(String coolor) {
        this.coolor = coolor;
    }

    public boolean isFly() {
        return fly;
    }

    public void setFly(boolean fly) {
        this.fly = fly;
    }
}
