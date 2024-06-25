package com.esercizio09.esercizio09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/cars")
public class CarController {

    @Autowired
    private CarRepository carRepo;

    @PostMapping
    public Car create(@RequestBody Car newCar) {
        Car savedCar = carRepo.saveAndFlush(newCar);
        return savedCar;
    }

    @GetMapping
    public List<Car> getAll() {
        List<Car> carsFound = carRepo.findAll();
        return carsFound;
    }

    @GetMapping(path = "/{id}")
    public Car getById(@PathVariable String id) {
        if (carRepo.existsById(id)) {
            return carRepo.findById(id).get();
        } else {
            return new Car();
        }
    }

    @PatchMapping(path = "/{id}/update")
    public Car updateType(@PathVariable String id,
                          @RequestParam CarType type) {
        if (carRepo.existsById(id)) {
            Car updatedCar = carRepo.findById(id).get();
            updatedCar.setType(type);
            carRepo.saveAndFlush(updatedCar);
            return updatedCar;
        } else {
            return new Car();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Car> deleteById(@PathVariable String id) {
        if (carRepo.existsById(id)) {
            Car deletedCar = carRepo.findById(id).get();
            carRepo.deleteById(id);
            return new ResponseEntity<>(deletedCar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Car(), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping
    public List<Car> deleteAll() {
        List<Car> deletedCars = carRepo.findAll();
        carRepo.deleteAll();
        return deletedCars;
    }

}