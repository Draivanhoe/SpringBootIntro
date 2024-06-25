package com.esercizio09.esercizio09;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {

    List<Car> findByModelName(String name);

    List<Car> findByType(CarType type);

}