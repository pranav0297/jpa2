package com.example.jpa.inheritence.demo_jpa2.inheritence.repo;

import com.example.jpa.inheritence.demo_jpa2.inheritence.payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<payment,Integer> {

}
