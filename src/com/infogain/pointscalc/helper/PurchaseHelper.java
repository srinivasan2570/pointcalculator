package com.infogain.pointscalc.helper;

import org.springframework.stereotype.Service;

import com.infogain.pointscalc.exception.PaymentStarterException;
import com.infogain.pointscalc.model.Purchase;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PurchaseHelper {

	public Purchase convert2Purchase(Long id, String amount) throws PaymentStarterException
	{
		log.info("Customer id:::",id);
		log.info("Purchase amount:::",amount);
		Purchase purchase = new Purchase();
		if(null != id && null != amount)
		{
			purchase.setCustomerId(id);
			purchase.setBillAmount(Double.valueOf(amount));
		}
		log.info("Purchase obj:::",purchase);
		return purchase;
		
	}
}
