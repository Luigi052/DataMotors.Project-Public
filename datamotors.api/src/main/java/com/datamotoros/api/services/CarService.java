package com.datamotoros.api.services;

import com.datamotoros.api.domain.dto.request.CarRequestsDTO;
import com.datamotoros.api.domain.dto.response.CarResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {

CarResponseDTO findById(Long id );

List<CarResponseDTO> findAll();

CarResponseDTO register(CarRequestsDTO CarsDTO);

CarResponseDTO update(Long id , CarRequestsDTO CarsDTO) ;

String delete(Long id) ;

}
