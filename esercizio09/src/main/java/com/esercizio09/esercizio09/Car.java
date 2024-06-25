package com.esercizio09.esercizio09;

import jakarta.persistence.*;

@Entity
@Table
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private String modelName;

    @Column
    private CarType type;

    // CONSTRUCTORS

    public Car() {
    }

    public Car(String id, String modelName, CarType type) {
        this.id = id;
        this.modelName = modelName;
        this.type = type;
    }

    // GETTERS AND SETTERS

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

}