package com.pabloabal.payments.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "PEER_TO_PEER")
@DiscriminatorValue(value = "P2P")
public class PeerToPeer extends Payment{
}
