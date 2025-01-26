package com.example.repairserviceapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "equipments")
@ToString
@Getter
@Setter
public class Equipment {

    @Id
    @Column(name = "eq_code")
    private UUID id;

    @Column(name = "eq_name")
    private String name;

    @Column(name = "eq_serial_number")
    private String serialNumber;

    @Column(name = "model")
    private String model;
}
