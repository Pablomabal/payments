package com.pabloabal.payments.service.kafka;

import com.pabloabal.payments.dto.PaymentDTO;
import com.pabloabal.payments.entity.Payment;
import com.pabloabal.payments.mapper.PaymentMapper;
import com.pabloabal.payments.repository.PaymentRepository;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.SocketTimeoutException;

import static com.pabloabal.payments.config.KafkaTopicConfiguration.PAYMENTS_TOPIC;


@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper mapper;

    public PaymentService (PaymentRepository paymentRepository,
                           PaymentMapper mapper){
        this.paymentRepository = paymentRepository;
        this.mapper = mapper;
    }

    @KafkaHandler
    @KafkaListener(topics = PAYMENTS_TOPIC)
    @RetryableTopic(
            backoff = @Backoff(value = 3000L),
            attempts = "5",
            autoCreateTopics = "false")
    @Transactional(rollbackFor = Exception.class)
    public void consume(PaymentDTO request) throws SocketTimeoutException {
        Payment payment = mapper.map(request);
        paymentRepository.save(payment);
    }

}
