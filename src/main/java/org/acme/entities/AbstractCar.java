package org.acme.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.MappedSuperclass;

import java.time.Instant;

@MappedSuperclass
public abstract class AbstractCar extends PanacheEntity {
    @JsonProperty("ownerNameSurname")
    public String owner_name_surname;
    @JsonProperty("serialNumber")
    public String serial_number;
    @JsonProperty("softwareVersion")
    public String software_version;
    @JsonProperty("techComments")
    public String tech_comments;
    @JsonProperty("buyingDay")
    public Instant buying_day;
    @JsonProperty("editedBy")
    public String edited_by;
    @JsonProperty("lastUpdateDate")
    public Instant last_update_date;
    @JsonProperty("lockedBy")
    public String locked_by;
    @JsonProperty("generalComments")
    public String general_comments;
    @JsonProperty("salesComments")
    public String sales_comments;
    @JsonProperty("batteryChangeDate")
    public Instant battery_change_date;
    @JsonProperty("paymentStatus")
    public String payment_status;
    @JsonProperty("finalPrice")
    public String final_price;
    @JsonProperty("initialPrice")
    public String initial_price;
    @JsonProperty("airConditioning")
    public String air_conditioning;
    @JsonProperty("fuelType")
    public String fuel_type;
    public String seats;
    public String transmission;
    public String gps;
    public String bluetooth;
    public String status;
    public String color;

    public AbstractCar(){}
}
