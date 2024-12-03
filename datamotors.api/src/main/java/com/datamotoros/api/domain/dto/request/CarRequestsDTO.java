package com.datamotoros.api.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CarRequestsDTO {

    public String brand;

    public String model;

    public String version;

    public String type;

    public int price;

    public String color;

    public String transmission;

    public String doors;

    public int mileage;

    public String city;

    public String state;

    public int fabYear;

    public int modelYear;

    public Date date;

}
