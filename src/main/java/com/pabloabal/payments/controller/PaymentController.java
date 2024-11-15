package com.pabloabal.payments.controller;

import com.pabloabal.payments.dto.CreatePaymentResultDTO;
import com.pabloabal.payments.dto.PaymentDTO;
import com.pabloabal.payments.service.kafka.PaymentsProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/payments")
public class PaymentController {

    private PaymentsProducer producer;

    public PaymentController(PaymentsProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public ResponseEntity<CreatePaymentResultDTO> createPayment(@RequestBody PaymentDTO request){
        producer.sendMessage(request);
        return ResponseEntity.ok().build();
    }

}
