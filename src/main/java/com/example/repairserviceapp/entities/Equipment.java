package com.example.repairserviceapp.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "equipments")
@Getter
@Setter
@ToString
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Equipment extends BaseEquipment {

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "equipment")
    private List<Order> orders;
}
