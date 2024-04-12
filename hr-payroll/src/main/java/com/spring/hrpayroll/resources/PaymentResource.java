
package com.spring.hrpayroll.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.hrpayroll.entities.Payment;
import com.spring.hrpayroll.services.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentResource {

	private static Logger logger = LoggerFactory.getLogger(PaymentResource.class);
	private final PaymentService paymentService;

	public PaymentResource(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable(name = "workerId") Long workerId,
			@PathVariable(name = "days") Integer days) {
		
		Payment payment = paymentService.getPayment(workerId, days);
		logger.info("Buscando pagamento: " + payment);
		
		return ResponseEntity.ok(payment);
	}
}
