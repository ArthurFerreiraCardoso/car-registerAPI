package com.teste.wswork.carregisterAPI.service;

import com.teste.wswork.carregisterAPI.validate.ValidateData;
import com.teste.wswork.carregisterAPI.dtos.car.CarDTORequest;
import com.teste.wswork.carregisterAPI.dtos.car.CarDTOResponse;
import com.teste.wswork.carregisterAPI.mapper.CarMapper;
import com.teste.wswork.carregisterAPI.models.Car;
import com.teste.wswork.carregisterAPI.repositories.CarRepository;
import com.teste.wswork.carregisterAPI.repositories.ModelRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarMapper carMapper;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ModelRepository modelRepository;


    public List<CarDTOResponse> findAll() {
        List<Car> cars = carRepository.findAll();
        return carMapper.listToCarDTOResponseList(cars);
    }

    public CarDTOResponse findById(Long id) throws NotFoundException {
        Optional<Car> carOptional = carRepository.findById(id);
        if (carOptional.isPresent()) {
            Car car = carOptional.get();
            return carMapper.toCarDTO(car);
        } else {
            throw new NotFoundException("Car not found with ID: " + id);
        }
    }

    public Car saveCar(CarDTORequest carDTORequest) throws NotFoundException {
        Car car = carMapper.toCar(carDTORequest);
        car.setModel(ValidateData.validateModel(carDTORequest.getModel(), modelRepository));
        return carRepository.save(car);
    }

    public CarDTORequest updateCar(Long id, CarDTORequest carDTORequest) throws NotFoundException {
        Car carId = carRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Car not found with ID: " + id));

        Car carUpdate = carMapper.toCar(carDTORequest);
        carId.setModel(carUpdate.getModel());
        carId.setColor(carUpdate.getColor());
        carId.setGas(carUpdate.getGas());
        carId.setName(carUpdate.getName());
        carId.setYear(carUpdate.getYear());
        carId.setNumDoors(carUpdate.getNumDoors());
        carRepository.save(carId);

        return carMapper.toCarDTORequest(carId);
    }

    public void delete(Long id) throws NotFoundException {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Car not found with ID: " + id));
        carRepository.delete(car);
    }
}
