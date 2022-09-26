package com.infogain.pointscalc.impl;

import org.springframework.stereotype.Service;

import com.infogain.pointscalc.interfaces.IPointsCalculator;
import com.infogain.pointscalc.model.Payments;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PointsCalculatorImpl implements IPointsCalculator {
	
	
	@Override
	public Payments calculatePoints(Double purchaseValue)
	{
		Payments payments = new Payments();
		Integer twoPoints = 0;
		Integer onePoint = 0;
		
		if(purchaseValue > 100 )
		{
			Double twoPointsMultiplier = purchaseValue - 100;
			twoPoints = twoPointsMultiplier.intValue() * 1 ;
			onePoint = 50;  // As per given instruction adding flat 50 points for all purchases
			twoPoints = 0 + twoPoints; //0   payments.getPoints() If old customer previous value will be added
			payments.setPoints(twoPoints + onePoint );			
		}
		
		log.info("Builded Payments::",payments);
		return payments;
	}

}
