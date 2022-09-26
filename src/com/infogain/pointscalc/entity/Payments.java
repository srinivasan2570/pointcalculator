package com.infogain.pointscalc.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PAYMENTS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payments implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	
	@Column(name = "cus_Id")	
	private Long customerId;
	@Column(name = "points")	
	private Integer points;
	@Column(name = "amount")
	private Double amount;
	@Column(name="date")
	private LocalDate date;


	

}
