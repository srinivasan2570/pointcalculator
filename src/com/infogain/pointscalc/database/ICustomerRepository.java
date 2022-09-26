package com.infogain.pointscalc.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infogain.pointscalc.entity.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

}
