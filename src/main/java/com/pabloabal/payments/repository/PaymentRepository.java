package com.pabloabal.payments.repository;

import com.pabloabal.payments.entity.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository<T extends Payment> extends CrudRepository<T, Long> {


    List<T> findByUserId(Long userId);
}
