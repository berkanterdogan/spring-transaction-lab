package com.berkanterdogan.lab.springtransactionlab.repository;

import com.berkanterdogan.lab.springtransactionlab.domain.Bicycle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BicycleRepository extends JpaRepository<Bicycle, Long> {
}
