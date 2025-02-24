package com.example.repairserviceapp.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "orders_history")
@Getter
@Setter
@ToString
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class OrderHistory extends BaseOrder {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="client_code", referencedColumnName = "client_code")
    private ClientHistory client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="equipment_code", referencedColumnName = "eq_code")
    private EquipmentHistory equipment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="master_code")
    private MasterHistory master;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="order_status", referencedColumnName="status_code")
    private StatusHistory status;

    @OneToOne(fetch = FetchType.EAGER, orphanRemoval=true)
    @JoinColumn(name="order_components_code", referencedColumnName = "co_code")
    private OrderOfComponentsHistory orderOfComponents;
}
