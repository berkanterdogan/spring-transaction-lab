package com.berkanterdogan.lab.springtransactionlab.service.impl;

import com.berkanterdogan.lab.springtransactionlab.domain.Bicycle;
import com.berkanterdogan.lab.springtransactionlab.domain.Car;
import com.berkanterdogan.lab.springtransactionlab.service.BicycleService;
import com.berkanterdogan.lab.springtransactionlab.service.CarService;
import com.berkanterdogan.lab.springtransactionlab.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@RequiredArgsConstructor
@Service
public class DefaultVehicleService implements VehicleService {

    private final CarService carService;
    private final BicycleService bicycleService;

    @Override
    @Transactional
    public void deleteAll() {
        carService.deleteAll();
        bicycleService.deleteAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveWithThisTxPropagationRequiredAndCarTxPropagationSupportsAndBicyclePropagationRequired(Car car, Bicycle bicycle) {
        carService.saveWithPropagationSupports(car);
        bicycleService.saveWithPropagationRequired(bicycle);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveWithThisTxPropagationRequiredAndCarTxPropagationSupportsAndBicyclePropagationRequiresNew(Car car, Bicycle bicycle) {
        carService.saveWithPropagationSupports(car);
        bicycleService.saveWithPropagationRequiresNew(bicycle);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveWithThisTxPropagationRequiredAndCarTxPropagationSupportsAndBicyclePropagationSupports(Car car, Bicycle bicycle) {
        carService.saveWithPropagationSupports(car);
        bicycleService.saveWithPropagationSupports(bicycle);
    }

    @Override
    public void saveWithThisNoTransactionalAndCarTxPropagationSupportsAndBicyclePropagationSupports(Car car, Bicycle bicycle) {
        carService.saveWithPropagationSupports(car);
        bicycleService.saveWithPropagationSupports(bicycle);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveWithThisTxPropagationRequiredAndCarTxPropagationSupportsAndBicyclePropagationNotSupported(Car car, Bicycle bicycle) {
        carService.saveWithPropagationSupports(car);
        bicycleService.saveWithPropagationNotSupported(bicycle);
    }

    @Override
    public void saveWithThisNoTransactionalAndCarTxPropagationSupportsAndBicyclePropagationNotSupported(Car car, Bicycle bicycle) {
        carService.saveWithPropagationSupports(car);
        bicycleService.saveWithPropagationNotSupported(bicycle);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveWithThisTxPropagationRequiredAndCarTxPropagationSupportsAndBicyclePropagationMandatory(Car car, Bicycle bicycle) {
        carService.saveWithPropagationSupports(car);
        bicycleService.saveWithPropagationMandatory(bicycle);
    }

    @Override
    public void saveWithThisNoTransactionalAndCarTxPropagationSupportsAndBicyclePropagationMandatory(Car car, Bicycle bicycle) {
        carService.saveWithPropagationSupports(car);
        bicycleService.saveWithPropagationMandatory(bicycle);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveWithThisTxPropagationRequiredAndCarTxPropagationSupportsAndBicyclePropagationNever(Car car, Bicycle bicycle) {
        carService.saveWithPropagationSupports(car);
        bicycleService.saveWithPropagationNever(bicycle);
    }

    @Override
    public void saveWithThisNoTransactionalAndCarTxPropagationSupportsAndBicyclePropagationNever(Car car, Bicycle bicycle) {
        carService.saveWithPropagationSupports(car);
        bicycleService.saveWithPropagationNever(bicycle);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveWithThisTxPropagationRequiredAndCarTxPropagationSupportsAndBicyclePropagationRequiresNewThrowCheckedException(Car car, Bicycle bicycle) throws SQLException {
        carService.saveWithPropagationSupports(car);
        bicycleService.saveWithPropagationRequiresNewAndThrowCheckedException(bicycle);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SQLException.class})
    public void saveWithThisTxPropagationRequiredAndCarTxPropagationSupportsAndBicyclePropagationRequiresNewThrowCheckedExceptionRollbackFor(Car car, Bicycle bicycle) throws SQLException {
        carService.saveWithPropagationSupports(car);
        bicycleService.saveWithPropagationRequiresNewAndThrowCheckedExceptionAndRollbackFor(bicycle);
    }
}
