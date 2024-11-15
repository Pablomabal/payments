package com.pabloabal.payments.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CREDIT_CARD")
@DiscriminatorValue(value = "CREDIT_CARD")
public class CreditCard  extends Payment{

    @ManyToOne
    private Merchant merchant;
}
