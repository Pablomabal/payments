package com.pabloabal.payments.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "USER")
public class User {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "userId")
    private List<Payment> payments;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
