package org.acme.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "history")
public class History extends AbstractCar {
    @JoinColumn(name = "car_id")
    @ManyToOne
    public Car car;
    public History(){
        super();
    }
}
