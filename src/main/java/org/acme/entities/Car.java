package org.acme.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "car")
public class Car extends AbstractCar {
    public String model;
    public String brand;
    public String year;
    public Car(){
        super();
    }
}
