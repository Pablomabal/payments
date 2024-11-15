package com.pabloabal.payments.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

    public static final String PAYMENTS_TOPIC = "payments";

    @Bean
    public NewTopic ccPaymentsTopic(){
        return TopicBuilder.name(PAYMENTS_TOPIC).build();
    }
}
