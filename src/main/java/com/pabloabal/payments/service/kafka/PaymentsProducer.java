package com.pabloabal.payments.service.kafka;

import com.pabloabal.payments.dto.PaymentDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.pabloabal.payments.config.KafkaTopicConfiguration.PAYMENTS_TOPIC;


@Service
public class PaymentsProducer {

    private final KafkaTemplate<String, PaymentDTO> template;

    public PaymentsProducer(KafkaTemplate<String, PaymentDTO> template){
        this.template = template;
    }

    public void sendMessage(PaymentDTO request) {
        template.send(PAYMENTS_TOPIC, request);
    }
}
