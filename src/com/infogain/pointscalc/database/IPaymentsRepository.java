package com.infogain.pointscalc.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.infogain.pointscalc.entity.Payments;

@Repository
public interface IPaymentsRepository extends JpaRepository<Payments, Long> {

	@Query("SELECT p FROM Payments p WHERE p.customerId =:customerId")
	List<Payments> findAllPaymentsByCustomerId(@Param("customerId")  Long customerId);
	
	}
