package com.example.repairserviceapp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders_statuses")
@Setter
@Getter
@ToString
public class Status {

    @Id
    @Column(name = "status_code")
    private UUID id;

    @Column(name = "status_name")
    private String name;

    @OneToMany(mappedBy = "status")
    @ToString.Exclude
    private List<Order> orders;
}
