package org.acme.entities;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "history")
public class History extends AbstractCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @JsonbProperty("historyId")
    public Long history_id;
    @JsonbProperty("carId")
    @JoinColumn(name = "car_id")
    public Long car_id;
    public History(){
        super();
    }


}
