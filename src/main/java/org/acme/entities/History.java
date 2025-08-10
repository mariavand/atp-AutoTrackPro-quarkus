package org.acme.entities;

import io.quarkus.panache.common.Sort;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.*;

import java.util.List;

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

    public static List<History> findAllByCarId(Long car_id){
        return History.list("car_id = ?1", Sort.by("history_id", Sort.Direction.Descending), car_id);
    }

}
