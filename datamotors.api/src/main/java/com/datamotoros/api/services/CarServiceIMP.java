package com.datamotoros.api.services;

import com.datamotoros.api.domain.dto.request.CarRequestsDTO;
import com.datamotoros.api.domain.dto.response.CarResponseDTO;
import com.datamotoros.api.entity.Car;
import com.datamotoros.api.repository.CarRepository;
import com.datamotoros.api.util.CarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class CarServiceIMP implements CarService {


    private final CarRepository carRepository;

    private final CarMapper carMapper;

    @Override
    public CarResponseDTO findById(Long id) {

        Car car = returnCar(id);

        return carMapper.toCarDTO(returnCar(id));

    }

    @Override
    public List<CarResponseDTO> findAll(){

        return carMapper.toCarDTO(carRepository.findAll());

    }

    @Override
    public CarResponseDTO register(CarRequestsDTO CarsDTO) {

        Car car = carMapper.toCar(CarsDTO);

        return carMapper.toCarDTO(carRepository.save(car));

    }

    @Override
    public CarResponseDTO update(Long id, CarRequestsDTO CarDTO) {

        Car car = returnCar(id);
        carMapper.updateCar(car,CarDTO);

       return carMapper.toCarDTO(carRepository.save(car));



    }
    @Override
    public String delete(Long id) {
        carRepository.deleteById (id);

        return "car id " +id+ "deleted" ;
    }


    private Car returnCar(Long id){
       return carRepository.findById(id)
               .orElseThrow(()-> new RuntimeException("erro carro nao encontrado"));
    }


}
