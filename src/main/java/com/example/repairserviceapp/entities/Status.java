package com.example.repairserviceapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "orders_statuses")
public class Status {

    @Id
    @Column(name = "status_code")
    private UUID id;

    @Column(name = "status_name")
    private String name;
}
