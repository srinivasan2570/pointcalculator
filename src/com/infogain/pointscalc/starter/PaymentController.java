package com.infogain.pointscalc.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.infogain.pointscalc.database.IPaymentsRepository;
import com.infogain.pointscalc.entity.Payments;
import com.infogain.pointscalc.exception.PaymentStarterException;
import com.infogain.pointscalc.helper.PurchaseHelper;
import com.infogain.pointscalc.interfaces.IPaymentsService;
import com.infogain.pointscalc.interfaces.IPointsManager;
import com.infogain.pointscalc.model.Purchase;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PaymentController {

	@Autowired
	private IPaymentsService paymentService;
	
	@Autowired
	private IPointsManager pointsManager;
	
	@Autowired
	private PurchaseHelper purchaseHelper;
	
	@Autowired
	private IPaymentsRepository paymentRepository;
	/**
	 * To load the payment record for given paymentId
	 * @param paymentId
	 * @return
	 */
	@GetMapping(path ="/{paymentId}")
	public Payments loadPurchaseHistory(@PathVariable String paymentId)
	{
		System.out.println("Payment Id ::"+paymentId);
		Payments payments =	paymentService.findbyPaymentsId(Long.valueOf(paymentId));
		return payments;
	}
	
	/**
	 * To insert a new payment we need to send payment id and purchase amount
	 * @param id
	 * @param amount
	 * @return
	 */
	@GetMapping(path = "/calcPoints/{id}/{amount}")
	public String doCalcPoints(@PathVariable Long id, @PathVariable String amount) {
		
		System.out.println("Customer Id ::"+id);
		System.out.println("Payment amount ::"+amount);
		try {
			pointsManager.doGeneratePoints(amount);
			Purchase purchase = purchaseHelper.convert2Purchase(id, amount);
		} catch (PaymentStarterException e) {
		log.info("Error Message is :::",e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Repo call :id:"+id);
		log.info ("Purchase objects::", paymentRepository.findAllPaymentsByCustomerId(id));
		return "success";	
		
	}
}
