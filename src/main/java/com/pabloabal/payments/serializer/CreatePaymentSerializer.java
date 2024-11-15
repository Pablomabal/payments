package com.pabloabal.payments.serializer;
import com.pabloabal.payments.entity.Payment;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;
import java.io.Serializable;
import java.util.Map;

public class CreatePaymentSerializer implements Serializer<Payment>, Serializable {

    @Override
    public void configure(Map configs, boolean isKey) {
        Serializer.super.configure(configs, isKey);
    }

    @Override
    public byte[] serialize(String topic, Payment data) {
        return new byte[0];
    }

    @Override
    public void close() {
        Serializer.super.close();
    }
}
