package com.example.repairserviceapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "order_executions")
public class ExecutionOfOrder {

    @Id
    @Column(name = "ex_code")
    private UUID id;

    @Column(name = "type_of_work")
    private String typeOfWork;

    @Column(name = "ex_cost")
    private BigDecimal exCost;

    @Column(name = "components_cost")
    private BigDecimal componentsCost;

    @Column(name = "ex_date")
    private LocalDate executionDate;

    @Column(name = "total_cost")
    private BigDecimal totalCost;

}
