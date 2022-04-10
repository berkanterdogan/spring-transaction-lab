package com.berkanterdogan.lab.springtransactionlab.bootstrap;

import com.berkanterdogan.lab.springtransactionlab.domain.Car;
import com.berkanterdogan.lab.springtransactionlab.domain.Bicycle;
import com.berkanterdogan.lab.springtransactionlab.service.VehicleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.IllegalTransactionStateException;

@Slf4j
@RequiredArgsConstructor
@Component
public class SpringTransactionLabApplicationLoader implements CommandLineRunner {

    public static final String DASH_SEPARATOR = "-----------------------------------------------------------------------------------------------------";

    private final VehicleService vehicleService;

    @Override
    public void run(String... args) throws Exception {
        vehicleService.deleteAll();

        Car car = Car.createWithoutId("car1", 8000L);
        Bicycle bicycle = Bicycle.createWithoutId("bicycle1");
        log.info("Calling vehicleService.saveWithThisTxPropagationRequiredAndCarTxPropagationRequiredAndBicyclePropagationRequired(car, bicycle)");
        vehicleService.saveWithThisTxPropagationRequiredAndCarTxPropagationSupportsAndBicyclePropagationRequired(car, bicycle);
        log.info(DASH_SEPARATOR);

        car = Car.createWithoutId("car2", 8000L);
        bicycle = Bicycle.createWithoutId("bicycle2");
        log.info("Calling vehicleService.saveWithThisTxPropagationRequiredAndCarTxPropagationRequiredAndBicyclePropagationRequiresNew(car, bicycle)");
        vehicleService.saveWithThisTxPropagationRequiredAndCarTxPropagationSupportsAndBicyclePropagationRequiresNew(car, bicycle);
        log.info(DASH_SEPARATOR);

        car = Car.createWithoutId("car3", 8000L);
        bicycle = Bicycle.createWithoutId("bicycle3");
        log.info("Calling vehicleService.saveWithThisTxPropagationRequiredAndCarTxPropagationRequiredAndBicyclePropagationSupports(car, bicycle)");
        vehicleService.saveWithThisTxPropagationRequiredAndCarTxPropagationSupportsAndBicyclePropagationSupports(car, bicycle);
        log.info(DASH_SEPARATOR);

        car = Car.createWithoutId("car4", 8000L);
        bicycle = Bicycle.createWithoutId("bicycle4");
        log.info("Calling vehicleService.saveWithThisNoTransactionalAndCarTxPropagationRequiredAndBicyclePropagationSupports(car, bicycle)");
        vehicleService.saveWithThisNoTransactionalAndCarTxPropagationSupportsAndBicyclePropagationSupports(car, bicycle);
        log.info(DASH_SEPARATOR);

        car = Car.createWithoutId("car5", 8000L);
        bicycle = Bicycle.createWithoutId("bicycle5");
        log.info("Calling vehicleService.saveWithThisTxPropagationRequiredAndCarTxPropagationRequiredAndBicyclePropagationNotSupported(car, bicycle)");
        vehicleService.saveWithThisTxPropagationRequiredAndCarTxPropagationSupportsAndBicyclePropagationNotSupported(car, bicycle);
        log.info(DASH_SEPARATOR);

        car = Car.createWithoutId("car6", 8000L);
        bicycle = Bicycle.createWithoutId("bicycle6");
        log.info("Calling vehicleService.saveWithThisNoTransactionalAndCarTxPropagationSupportsAndBicyclePropagationNotSupported(car, bicycle)");
        vehicleService.saveWithThisNoTransactionalAndCarTxPropagationSupportsAndBicyclePropagationNotSupported(car, bicycle);
        log.info(DASH_SEPARATOR);

        car = Car.createWithoutId("car7", 8000L);
        bicycle = Bicycle.createWithoutId("bicycle7");
        log.info("Calling vehicleService.saveWithThisTxPropagationRequiredAndCarTxPropagationSupportsAndBicyclePropagationMandatory(car, bicycle)");
        vehicleService.saveWithThisTxPropagationRequiredAndCarTxPropagationSupportsAndBicyclePropagationMandatory(car, bicycle);
        log.info(DASH_SEPARATOR);

        car = Car.createWithoutId("car8", 8000L);
        bicycle = Bicycle.createWithoutId("bicycle8");
        log.info("Calling vehicleService.saveWithThisNoTransactionalAndCarTxPropagationSupportsAndBicyclePropagationMandatory(car, bicycle)");
        try {
            vehicleService.saveWithThisNoTransactionalAndCarTxPropagationSupportsAndBicyclePropagationMandatory(car, bicycle);
        } catch (IllegalTransactionStateException e) {
            log.error(e.getMessage(), e);
        }
        log.info(DASH_SEPARATOR);

        car = Car.createWithoutId("car9", 8000L);
        bicycle = Bicycle.createWithoutId("bicycle9");
        log.info("Calling vehicleService.saveWithThisTxPropagationRequiredAndCarTxPropagationSupportsAndBicyclePropagationNever(car, bicycle)");
        try {
            vehicleService.saveWithThisTxPropagationRequiredAndCarTxPropagationSupportsAndBicyclePropagationNever(car, bicycle);
        } catch (IllegalTransactionStateException e) {
            log.error(e.getMessage(), e);
        }
        log.info(DASH_SEPARATOR);

        car = Car.createWithoutId("car10", 8000L);
        bicycle = Bicycle.createWithoutId("bicycle10");
        log.info("Calling vehicleService.saveWithThisNoTransactionalAndCarTxPropagationSupportsAndBicyclePropagationNever(car, bicycle)");
        vehicleService.saveWithThisNoTransactionalAndCarTxPropagationSupportsAndBicyclePropagationNever(car, bicycle);
        log.info(DASH_SEPARATOR);

        car = Car.createWithoutId("car11", 8000L);
        bicycle = Bicycle.createWithoutId("bicycle11");
        log.info("Calling vehicleService.saveWithThisTxPropagationRequiredAndCarTxPropagationSupportsAndBicyclePropagationRequiresNewThrowCheckedException(car, bicycle)");
        try {
            vehicleService.saveWithThisTxPropagationRequiredAndCarTxPropagationSupportsAndBicyclePropagationRequiresNewThrowCheckedException(car, bicycle);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        log.info(DASH_SEPARATOR);

        car = Car.createWithoutId("car12", 8000L);
        bicycle = Bicycle.createWithoutId("bicycle12");
        log.info("Calling vehicleService.saveWithThisTxPropagationRequiredAndCarTxPropagationSupportsAndBicyclePropagationRequiresNewThrowCheckedExceptionRollbackFor(car, bicycle)");
        try {
            vehicleService.saveWithThisTxPropagationRequiredAndCarTxPropagationSupportsAndBicyclePropagationRequiresNewThrowCheckedExceptionRollbackFor(car, bicycle);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        log.info(DASH_SEPARATOR);
    }
}
