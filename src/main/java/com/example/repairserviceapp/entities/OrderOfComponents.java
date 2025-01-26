package com.example.repairserviceapp.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "components_order")
public class OrderOfComponents {

    @Id
    @Column(name = "co_code")
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "component_code", referencedColumnName = "components_code")
    private ComponentsWarehouse componentsWarehouse;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "execution_code", referencedColumnName = "ex_code")
    private ExecutionOfOrder executionOfOrder;
}
