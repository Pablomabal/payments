package com.pabloabal.payments.mapper;

import com.pabloabal.payments.dto.*;
import com.pabloabal.payments.dto.TransferPaymentDTO;
import com.pabloabal.payments.dto.PaymentDTO;
import com.pabloabal.payments.entity.CreditCard;
import com.pabloabal.payments.entity.Payment;
import com.pabloabal.payments.entity.PeerToPeer;
import com.pabloabal.payments.entity.Transfer;
import org.mapstruct.Mapper;
import org.mapstruct.SubclassExhaustiveStrategy;
import org.mapstruct.SubclassMapping;

import java.util.List;

@Mapper(subclassExhaustiveStrategy = SubclassExhaustiveStrategy.RUNTIME_EXCEPTION)
public interface PaymentMapper {

    @SubclassMapping(source = P2PPaymentDTO.class, target = PeerToPeer.class)
    @SubclassMapping(source = CCPaymentDTO.class, target = CreditCard.class)
    @SubclassMapping(source = TransferPaymentDTO.class, target = Transfer.class)
    Payment map(PaymentDTO paymentRequest);

    @SubclassMapping(source = PeerToPeer.class, target = P2PPaymentDTO.class)
    @SubclassMapping(source = CreditCard.class, target = CCPaymentDTO.class)
    @SubclassMapping(source = Transfer.class, target = TransferPaymentDTO.class)
    PaymentDTO map(Payment payment);

    List<PaymentDTO> mapAll(List<Payment> payment);
}
