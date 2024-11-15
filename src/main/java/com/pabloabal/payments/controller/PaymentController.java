package com.pabloabal.payments.controller;

import com.pabloabal.payments.dto.*;
import com.pabloabal.payments.entity.Payment;
import com.pabloabal.payments.entity.PaymentStatus;
import com.pabloabal.payments.service.kafka.PaymentsProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

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

    @GetMapping
    public ResponseEntity<Payment> test() {
        var request = new TransferPaymentDTO();
        request.setType("asd");
        request.setAmount(BigDecimal.ONE);
        request.setCurrency("USD");
        request.setRate(BigDecimal.ONE);
        request.setStatus(PaymentStatus.COMPLETED);
        request.setCreatedAt(Date.from(Instant.now()));
        producer.sendMessage(request);
        return ResponseEntity.ok().build();
    }
}
