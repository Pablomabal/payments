package com.pabloabal.payments.dto;

public class CCPaymentDTO extends PaymentDTO {

    private MerchantDTO merchant;

    public MerchantDTO getMerchant() {
        return merchant;
    }

    public void setMerchant(MerchantDTO merchant) {
        this.merchant = merchant;
    }
}