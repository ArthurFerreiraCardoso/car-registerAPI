package com.teste.wswork.carregisterAPI.repositories;

import com.teste.wswork.carregisterAPI.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
