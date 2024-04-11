package com.teste.wswork.carregisterAPI.controller;

import com.teste.wswork.carregisterAPI.dtos.car.CarDTORequest;
import com.teste.wswork.carregisterAPI.dtos.car.CarDTOResponse;
import com.teste.wswork.carregisterAPI.service.CarService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping(value = "/car-list", produces = "application/json")
    public ResponseEntity<List<CarDTOResponse>> findAll() {
        List<CarDTOResponse> carList = carService.findAll();
        return ResponseEntity.ok().body(carList);
    }

    @GetMapping(value = "/search-by-id/{id}", produces = "application/json")
    public ResponseEntity<CarDTOResponse> findById(@PathVariable Long id) throws NotFoundException {
        CarDTOResponse carDTO = carService.findById(id);

        if (carDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(carDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping(value = "/save-car", produces = "application/json")
    public ResponseEntity<CarDTORequest> saveCar(@RequestBody CarDTORequest carDTORequest) {
        try {
            carService.saveCar(carDTORequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(carDTORequest);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(carDTORequest);
        }
    }

    @PutMapping(value = "/update-car/{id}", produces = "application/json")
    public ResponseEntity<CarDTORequest> updateCar(@PathVariable Long id, @RequestBody CarDTORequest carDTORequest) {
        try {
            carService.updateCar(id, carDTORequest);
            return ResponseEntity.status(HttpStatus.OK).body(carDTORequest);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @DeleteMapping(value = "/delete-car/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws NotFoundException {
        carService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}

