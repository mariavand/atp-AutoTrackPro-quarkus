package org.acme.entities;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "car")
public class Car extends AbstractCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @JsonbProperty("carId")
    public Long car_id;
    public String model;
    public String brand;
    public String year;
    public Car(){
        super();
    }
}
