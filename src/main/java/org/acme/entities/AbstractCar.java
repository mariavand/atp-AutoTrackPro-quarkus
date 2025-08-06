package org.acme.entities;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.json.bind.annotation.JsonbProperty;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;

@MappedSuperclass
public abstract class AbstractCar extends PanacheEntityBase {
    @JsonbProperty("ownerNameSurname")
    public String owner_name_surname;
    @JsonbProperty("serialNumber")
    public String serial_number;
    @JsonbProperty("softwareVersion")
    public String software_version;
    @JsonbProperty("techComments")
    public String tech_comments;
    @JsonbProperty("buyingDay")
    public LocalDate buying_day;

    @JsonbProperty("editedBy")
    public String edited_by;
    @JsonbProperty("lastUpdateDate")
    public Instant last_update_date;
    @JsonbProperty("generalComments")
    public String general_comments;
    @JsonbProperty("salesComments")
    public String sales_comments;
    @JsonbProperty("batteryChangeDate")
    public LocalDate battery_change_date;
    @JsonbProperty("paymentStatus")
    public String payment_status;
    @JsonbProperty("finalPrice")
    public Float final_price;
    @JsonbProperty("initialPrice")
    public Float initial_price;
    @JsonbProperty("airConditioning")
    public Boolean air_conditioning;
    @JsonbProperty("fuelType")
    public String fuel_type;
    public Integer transmission;
    public Boolean gps;
    public Boolean bluetooth;
    public String status;
    public String color;

    public AbstractCar(){}
}
