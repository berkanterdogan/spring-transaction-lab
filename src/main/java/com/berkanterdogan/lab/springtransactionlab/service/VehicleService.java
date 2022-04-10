package com.berkanterdogan.lab.springtransactionlab.service;

import com.berkanterdogan.lab.springtransactionlab.domain.Bicycle;
import com.berkanterdogan.lab.springtransactionlab.domain.Car;

import java.sql.SQLException;

public interface VehicleService {

    void deleteAll();

    void saveWithThisTxPropagationRequiredAndCarTxPropagationSupportsAndBicyclePropagationRequired(Car car, Bicycle bicycle);

    void saveWithThisTxPropagationRequiredAndCarTxPropagationSupportsAndBicyclePropagationRequiresNew(Car car, Bicycle bicycle);

    void saveWithThisTxPropagationRequiredAndCarTxPropagationSupportsAndBicyclePropagationSupports(Car car, Bicycle bicycle);

    void saveWithThisNoTransactionalAndCarTxPropagationSupportsAndBicyclePropagationSupports(Car car, Bicycle bicycle);

    void saveWithThisTxPropagationRequiredAndCarTxPropagationSupportsAndBicyclePropagationNotSupported(Car car, Bicycle bicycle);

    void saveWithThisNoTransactionalAndCarTxPropagationSupportsAndBicyclePropagationNotSupported(Car car, Bicycle bicycle);

    void saveWithThisTxPropagationRequiredAndCarTxPropagationSupportsAndBicyclePropagationMandatory(Car car, Bicycle bicycle);

    void saveWithThisNoTransactionalAndCarTxPropagationSupportsAndBicyclePropagationMandatory(Car car, Bicycle bicycle);

    void saveWithThisTxPropagationRequiredAndCarTxPropagationSupportsAndBicyclePropagationNever(Car car, Bicycle bicycle);

    void saveWithThisNoTransactionalAndCarTxPropagationSupportsAndBicyclePropagationNever(Car car, Bicycle bicycle);

    void saveWithThisTxPropagationRequiredAndCarTxPropagationSupportsAndBicyclePropagationRequiresNewThrowCheckedException(Car car, Bicycle bicycle) throws SQLException;

    void saveWithThisTxPropagationRequiredAndCarTxPropagationSupportsAndBicyclePropagationRequiresNewThrowCheckedExceptionRollbackFor(Car car, Bicycle bicycle) throws SQLException;
}
