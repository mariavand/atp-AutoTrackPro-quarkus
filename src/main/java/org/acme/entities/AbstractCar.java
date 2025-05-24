package org.acme.entities;

import jakarta.json.bind.annotation.JsonbProperty;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.time.Instant;

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
    public Instant buying_day;
    @JsonbProperty("editedBy")
    public String edited_by;
    @JsonbProperty("lastUpdateDate")
    public Instant last_update_date;
    @JsonbProperty("lockedBy")
    public String locked_by;
    @JsonbProperty("generalComments")
    public String general_comments;
    @JsonbProperty("salesComments")
    public String sales_comments;
    @JsonbProperty("batteryChangeDate")
    public Instant battery_change_date;
    @JsonbProperty("paymentStatus")
    public String payment_status;
    @JsonbProperty("finalPrice")
    public String final_price;
    @JsonbProperty("initialPrice")
    public String initial_price;
    @JsonbProperty("airConditioning")
    public String air_conditioning;
    @JsonbProperty("fuelType")
    public String fuel_type;
    public String seats;
    public String transmission;
    public String gps;
    public String bluetooth;
    public String status;
    public String color;

    public AbstractCar(){}
}
