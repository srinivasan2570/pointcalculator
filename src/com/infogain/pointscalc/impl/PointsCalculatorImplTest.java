package com.infogain.pointscalc.impl;



import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.infogain.pointscalc.exception.PaymentCalculatorException;
import com.infogain.pointscalc.exception.PaymentStarterException;
import com.infogain.pointscalc.interfaces.IPointsCalculator;
import com.infogain.pointscalc.model.Payments;

/**
 * Test Case for Calculating Points
 * @author Aravindh S
 *
 */

class PointsCalculatorImplTest {

	private IPointsCalculator pointsCalcImpl;
	
	
	@BeforeEach
	public void setUp()
	{
		pointsCalcImpl = new PointsCalculatorImpl();
		
	}
	/**
	 *  12 is less than 100
	 */
	@Test
	void testWithLessThan100DollarsPurchaseValue()throws PaymentStarterException {
		
		Payments payments = pointsCalcImpl.calculatePoints(12d);
		assertNotEquals(Integer.valueOf(0),payments.getPoints());
		
	}
	/**
	 * 100 is equal boundary condition lower limit
	 */
	@Test
	void testWith100DollarsPurchaseValue()throws PaymentStarterException {
	
		Payments payments = pointsCalcImpl.calculatePoints(100d);
		assertNull(payments.getPoints());
	}
	
	/**
	 * 101 is greater than minimal value
	 */
	@Test
	void testWith101DollarsPurchaseValue() {
	
		Payments payments =null;
		try {
			payments = pointsCalcImpl.calculatePoints(101d);
		} catch (PaymentCalculatorException e) {
			
			e.printStackTrace();
		}
		assertNotNull(payments.getPoints());
		assertEquals(51, payments.getPoints());
	}
	
	/**
	 *  is greater than minimal value
	 */
	@Test
	void testWithMaxDollarsPurchaseValue()throws PaymentStarterException {
	
		Payments payments = pointsCalcImpl.calculatePoints(2147483647d);
		assertNotNull(payments.getPoints());
		assertEquals(2147483597, payments.getPoints());
	}

}
