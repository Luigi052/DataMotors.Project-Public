package com.datamotoros.api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "tb_cars")
@NoArgsConstructor
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private long id;

    @Column(name = "brand", nullable = true, unique = false)
    private String brand;

    @Column(name = "model", nullable = true, unique = false)
    private String model;

    @Column(name = "version", nullable = true, unique = false)
    private String version;

    @Column(name = "type", nullable = true, unique = false)
    private String type;

    @Column(name = "price", nullable = true, unique = false)
    private int price;

    @Column(name = "color", nullable = true, unique = false)
    private String color;

    @Column(name = "transmission", nullable = true, unique = false)
    private String transmission;

    @Column(name = "doors", nullable = true, unique = false)
    private String doors;

    @Column(name = "mileage", nullable = true, unique = false)
    private int mileage;

    @Column(name = "city", nullable = true, unique = false)
    private String city;

    @Column(name = "state", nullable = true, unique = false)
    private String state;

    @Column(name = "fabyear", nullable = true, unique = false)
    private int fabYear;

    @Column(name = "modelyear", nullable = true, unique = false)
    private int modelYear;

    @Column(name = "date", nullable = true ,unique = false)
    private Date date ;

    @Builder
    public Car(String brand, String model, String version, String type, int price, String color, String transmission, String doors, int mileage, String city, String state, int fabYear, int modelYear, Date date) {
        this.brand = brand;
        this.model = model;
        this.version = version;
        this.type = type;
        this.price = price;
        this.color = color;
        this.transmission = transmission;
        this.doors = doors;
        this.mileage = mileage;
        this.city = city;
        this.state = state;
        this.fabYear = fabYear;
        this.modelYear = modelYear;
        this.date = date;
    }
}

