package com.berkanterdogan.lab.springtransactionlab.service.impl;

import com.berkanterdogan.lab.springtransactionlab.domain.Bicycle;
import com.berkanterdogan.lab.springtransactionlab.repository.BicycleRepository;
import com.berkanterdogan.lab.springtransactionlab.service.BicycleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@RequiredArgsConstructor
@Service
public class DefaultBicycleService implements BicycleService {

    private final BicycleRepository bicycleRepository;

    @Override
    public void deleteAll() {
        bicycleRepository.deleteAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Bicycle saveWithPropagationRequired(Bicycle appUserDetail) {
        return bicycleRepository.save(appUserDetail);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Bicycle saveWithPropagationRequiresNew(Bicycle appUserDetail) {
        return bicycleRepository.save(appUserDetail);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Bicycle saveWithPropagationSupports(Bicycle appUserDetail) {
        return bicycleRepository.save(appUserDetail);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Bicycle saveWithPropagationNotSupported(Bicycle appUserDetail) {
        return bicycleRepository.save(appUserDetail);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Bicycle saveWithPropagationMandatory(Bicycle appUserDetail) {
        return bicycleRepository.save(appUserDetail);
    }

    @Override
    @Transactional(propagation = Propagation.NEVER)
    public Bicycle saveWithPropagationNever(Bicycle appUserDetail) {
        return bicycleRepository.save(appUserDetail);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Bicycle saveWithPropagationRequiresNewAndThrowCheckedException(Bicycle appUserDetail) throws SQLException {
        bicycleRepository.save(appUserDetail);
        throw new SQLException("An exception has occured!");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = {SQLException.class})
    public Bicycle saveWithPropagationRequiresNewAndThrowCheckedExceptionAndRollbackFor(Bicycle appUserDetail) throws SQLException {
        bicycleRepository.save(appUserDetail);
        throw new SQLException("An exception has occured!");
    }

}
