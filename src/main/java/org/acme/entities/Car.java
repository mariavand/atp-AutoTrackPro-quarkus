package org.acme.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class Car extends PanacheEntity {
    @Column(name = "owner_name_surname")
    public String ownerNameSurname;
    @Column(name = "serial_number")
    public String serialNumber;
    @Column(name = "software_version")
    public String softwareVersion;
    public String model;
    @Column(name = "tech_comments")
    public String techComments;
    @Column(name = "buying_day")
    public Instant buyingDay;
    @Column(name = "edited_by")
    public String editedBy;
    @Column(name = "last_update_date")
    public Instant lastUpdateDate;
    @Column(name = "locked_by")
    public String lockedBy;
    @Column(name = "general_comments")
    public String generalComments;
    @Column(name = "sales_comments")
    public String salesComments;
    @Column(name = "battery_change_date")
    public Instant batteryChangeDate;
    @Column(name = "payment_status")
    public String paymentStatus;
    @Column(name = "final_price")
    public String finalPrice;
    @Column(name = "initial_price")
    public String initialPrice;
    public String status;
    public String brand;
    @Column(name = "air_conditioning")
    public String airConditioning;
    public String seats;
    public String transmission;
    public String gps;
    public String bluetooth;
    @Column(name = "fuel_type")
    public String fuelType;
    public String year;
    public String color;

    public Car(){}
}
