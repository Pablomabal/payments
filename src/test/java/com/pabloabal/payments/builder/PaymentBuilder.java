package com.pabloabal.payments.builder;

import com.pabloabal.payments.dto.PaymentDTO;
import com.pabloabal.payments.entity.Payment;
import com.pabloabal.payments.entity.PaymentStatus;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;

public class PaymentBuilder {

    private BigDecimal amount;
    private String currency;
    private Date createdAt;
    private PaymentStatus status;
    private Long userId;
    private BigDecimal rate;

    private PaymentBuilder() {}

    public static PaymentBuilder instance() {
        return new PaymentBuilder();
    }

    public PaymentBuilder withAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public PaymentBuilder withRate(BigDecimal rate) {
        this.rate = rate;
        return this;
    }

    public PaymentBuilder withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public PaymentBuilder withUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public PaymentBuilder withCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Payment build(Class<? extends Payment> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        var payment = clazz.getConstructor().newInstance();
        payment.setAmount(amount);
        payment.setCurrency(currency);
        payment.setCreatedAt(createdAt);
        payment.setRate(rate);
        payment.setStatus(status);
        payment.setUserId(userId);
        return payment;
    }

    public PaymentDTO buildDTO(Class<? extends PaymentDTO> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        var paymentDTO = clazz.getConstructor().newInstance();


        return paymentDTO;
    }
}
