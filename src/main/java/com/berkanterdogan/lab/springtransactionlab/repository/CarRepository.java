package com.berkanterdogan.lab.springtransactionlab.repository;

import com.berkanterdogan.lab.springtransactionlab.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
