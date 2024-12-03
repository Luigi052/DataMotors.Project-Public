package com.datamotoros.api.domain.dto.response;

import com.datamotoros.api.entity.Car;
import lombok.Getter;

import java.util.Date;

@Getter
public class CarResponseDTO {

    private long id;

    private String brand;

    private String model;

    private String version;

    private String type;

    private int price;

    private String color;

    private String transmission;

    private String doors;

    private int mileage;

    private String city;

    private String state;

    private int fabYear;

    private int modelYear;

    private Date date;

    public CarResponseDTO(Car car){
        this.id = car.getId();
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.version = car.getVersion();
        this.type = car.getType();
        this.price = car.getPrice();
        this.color = car.getColor();
        this.transmission = car.getTransmission();
        this.date = car.getDate();
        this.doors = car.getDoors();
        this.mileage = car.getMileage();
        this.city = car.getCity();
        this.state = car.getState();
        this.fabYear = getFabYear();
        this.modelYear = getModelYear();


   }

}



