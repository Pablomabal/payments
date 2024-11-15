package com.pabloabal.payments.mapper;

import com.pabloabal.payments.builder.PaymentBuilder;
import com.pabloabal.payments.dto.CCPaymentDTO;
import com.pabloabal.payments.dto.P2PPaymentDTO;
import com.pabloabal.payments.dto.TransferPaymentDTO;
import com.pabloabal.payments.entity.CreditCard;
import com.pabloabal.payments.entity.PeerToPeer;
import com.pabloabal.payments.entity.Transfer;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationTargetException;

@RunWith(SpringRunner.class)
public class PaymentMapperTest {

    @Test
    public void mapsToCorrectClass_CreditCard() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        PaymentMapper mapper = Mappers.getMapper(PaymentMapper.class);
        var resultDTO = mapper.map(PaymentBuilder.instance().build(CreditCard.class));
        Assertions.assertEquals(CCPaymentDTO.class, resultDTO.getClass());
    }

    @Test
    public void mapsToCorrectClass_Transfer() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        PaymentMapper mapper = Mappers.getMapper(PaymentMapper.class);
        var resultDTO = mapper.map(PaymentBuilder.instance().build(Transfer.class));
        Assertions.assertEquals(TransferPaymentDTO.class, resultDTO.getClass());
    }

    @Test
    public void mapsToCorrectClass_P2P() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        PaymentMapper mapper = Mappers.getMapper(PaymentMapper.class);
        var resultDTO = mapper.map(PaymentBuilder.instance().build(PeerToPeer.class));
        Assertions.assertEquals(P2PPaymentDTO.class, resultDTO.getClass());
    }
}
