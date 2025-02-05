package com.example.repairserviceapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="orders")
@Setter
@Getter
@ToString
public class Order {

    @Id
    @Column(name="order_code")
    private UUID id;

    @Column(name="order_date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="client_code", referencedColumnName = "client_code")

    @JsonIgnore
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="equipment_code", referencedColumnName = "eq_code")
    @ToString.Exclude
    @JsonIgnore
    private Equipment equipment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="master_code")
    @ToString.Exclude
    @JsonIgnore
    private Master master;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="order_status", referencedColumnName="status_code")
    @ToString.Exclude
    @JsonIgnore
    private Status status;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="order_components_code", referencedColumnName = "co_code")
    @JsonIgnore
    @ToString.Exclude
    private OrderOfComponents orderOfComponents;




}
