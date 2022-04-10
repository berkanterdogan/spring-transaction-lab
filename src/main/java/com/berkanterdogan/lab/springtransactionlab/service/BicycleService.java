package com.berkanterdogan.lab.springtransactionlab.service;

import com.berkanterdogan.lab.springtransactionlab.domain.Bicycle;

import java.sql.SQLException;

public interface BicycleService {

    void deleteAll();

    Bicycle saveWithPropagationRequired(Bicycle bicycle);

    Bicycle saveWithPropagationRequiresNew(Bicycle bicycle);

    Bicycle saveWithPropagationSupports(Bicycle bicycle);

    Bicycle saveWithPropagationNotSupported(Bicycle bicycle);

    Bicycle saveWithPropagationMandatory(Bicycle bicycle);

    Bicycle saveWithPropagationNever(Bicycle bicycle);

    Bicycle saveWithPropagationRequiresNewAndThrowCheckedException(Bicycle bicycle) throws SQLException;

    Bicycle saveWithPropagationRequiresNewAndThrowCheckedExceptionAndRollbackFor(Bicycle bicycle) throws SQLException;
}
