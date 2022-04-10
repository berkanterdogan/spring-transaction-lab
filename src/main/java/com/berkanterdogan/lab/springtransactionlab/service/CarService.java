package com.berkanterdogan.lab.springtransactionlab.service;

import com.berkanterdogan.lab.springtransactionlab.domain.Car;

public interface CarService {

    void deleteAll();

    Car saveWithPropagationSupports(Car car);
}
