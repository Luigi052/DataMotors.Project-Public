package com.datamotoros.api.controller;

import com.datamotoros.api.domain.dto.request.CarRequestsDTO;
import com.datamotoros.api.domain.dto.response.CarResponseDTO;
import com.datamotoros.api.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/car")
@RequiredArgsConstructor
public class CarController {



    private final CarService carService;

    @GetMapping(value ="/{id}")
    public ResponseEntity<CarResponseDTO> findById(@PathVariable(name = "id" ) long id) {

    return ResponseEntity.ok().body(carService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<CarResponseDTO>> findAll() {
    return ResponseEntity.ok().body(carService.findAll()) ;
    }
    @PostMapping
    public ResponseEntity<CarResponseDTO> register (@RequestBody CarRequestsDTO carDTO, UriComponentsBuilder UriBuilder ) {

        CarResponseDTO carResponseDTO = carService.register(carDTO);

        URI uri = UriBuilder.path("/car/{id}").buildAndExpand(carResponseDTO.getId()).toUri();

        return  ResponseEntity.created(uri).body(carResponseDTO);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CarResponseDTO> update(@RequestBody CarRequestsDTO carDTO , @PathVariable(name = "id") long id ){
        return ResponseEntity.ok().body(carService.update(id,carDTO));

    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete (@PathVariable(value = "id") long id ) {
        return ResponseEntity.ok(carService.delete(id));

    }

}
