package com.pabloabal.payments.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TRANSFER")
@DiscriminatorValue(value = "TRANSFER")
public class Transfer extends Payment{
}
