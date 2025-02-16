package com.example.repairserviceapp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "equipment", orphanRemoval = true)
    private List<Order> orders;
}
