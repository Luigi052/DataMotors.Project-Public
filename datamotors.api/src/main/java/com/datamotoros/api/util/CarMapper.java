package com.datamotoros.api.util;

import com.datamotoros.api.domain.dto.request.CarRequestsDTO;
import com.datamotoros.api.domain.dto.response.CarResponseDTO;
import com.datamotoros.api.entity.Car;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarMapper {

    public Car toCar(CarRequestsDTO carDTO){

        return Car.builder()
                .brand(carDTO.getBrand())
                .model(carDTO.getModel())
                .version(carDTO.getVersion())
                .type(carDTO.getType())
                .price(carDTO.getPrice())
                .color(carDTO.getColor())
                .transmission(carDTO.getTransmission())
                .doors(carDTO.getDoors())
                .mileage(carDTO.getMileage())
                .city(carDTO.getCity())
                .state(carDTO.getState())
                .fabYear(carDTO.getFabYear())
                .modelYear(carDTO.getModelYear())
                .date(carDTO.getDate())
                .build();
    }

    public  CarResponseDTO toCarDTO(Car car){
        return new CarResponseDTO(car);

    }

    public List<CarResponseDTO> toCarDTO(List<Car> carList){
        return carList.stream().map(CarResponseDTO::new).collect(Collectors.toList());
    }

    public void updateCar(Car car, CarRequestsDTO carDTO){

        car.setBrand(carDTO.getBrand());
        car.setModel(carDTO.getModel());
        car.setVersion(carDTO.getVersion());
        car.setType(carDTO.getType());
        car.setPrice(carDTO.getPrice());
        car.setColor(carDTO.getColor());
        car.setTransmission(carDTO.getTransmission());
        car.setDoors(carDTO.getDoors());
        car.setMileage(carDTO.getMileage());
        car.setCity(carDTO.getCity());
        car.setState(carDTO.getState());
        car.setFabYear(carDTO.getFabYear());
        car.setModelYear(carDTO.getModelYear());
        car.setDate(carDTO.getDate());



    }

}

