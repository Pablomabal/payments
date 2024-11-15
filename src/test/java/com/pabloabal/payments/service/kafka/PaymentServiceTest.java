package com.pabloabal.payments.service.kafka;

import com.pabloabal.payments.builder.PaymentBuilder;
import com.pabloabal.payments.dto.CCPaymentDTO;
import com.pabloabal.payments.entity.CreditCard;
import com.pabloabal.payments.entity.Payment;
import com.pabloabal.payments.mapper.PaymentMapper;
import com.pabloabal.payments.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.net.SocketTimeoutException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
class PaymentServiceTest {

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private PaymentMapper mapper;


    private PaymentService paymentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        paymentService = new PaymentService(paymentRepository, mapper);
    }

    @Test
    public void testProcessPayment() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, SocketTimeoutException {
        var builder = PaymentBuilder.instance();
        var dto = builder.buildDTO(CCPaymentDTO.class);
        Payment payment = new CreditCard();
        when(paymentRepository.save(any())).thenReturn(payment);
        paymentService.consume(dto);
        verify(mapper, Mockito.times(1)).map(dto);
    }
}