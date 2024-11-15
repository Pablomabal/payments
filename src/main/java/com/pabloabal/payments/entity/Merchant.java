package com.pabloabal.payments.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MERCHANT")
public class Merchant {

    @Id
    private Long id;
    private String name;
    private String merchantId;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
