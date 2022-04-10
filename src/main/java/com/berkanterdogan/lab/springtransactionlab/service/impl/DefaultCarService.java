package com.berkanterdogan.lab.springtransactionlab.service.impl;

import com.berkanterdogan.lab.springtransactionlab.domain.Car;
import com.berkanterdogan.lab.springtransactionlab.repository.CarRepository;
import com.berkanterdogan.lab.springtransactionlab.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DefaultCarService implements CarService {

    private final CarRepository carRepository;

    @Override
    public void deleteAll() {
        carRepository.deleteAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Car saveWithPropagationSupports(Car car) {
        return carRepository.save(car);
    }
}
