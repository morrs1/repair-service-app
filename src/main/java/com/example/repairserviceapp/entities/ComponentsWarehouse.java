package com.example.repairserviceapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "components_warehouse")
public class ComponentsWarehouse {

    @Id
    @Column(name = "components_code")
    private UUID componentsCode;

    @Column(name = "component_name")
    private String componentName;

    @Column(name = "components_amount")
    private Integer componentsAmount;

    @Column(name = "unit_cost")
    private BigDecimal unitCost;

}
