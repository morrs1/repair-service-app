package com.example.repairserviceapp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "clients")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @Column(name = "client_code")
    private UUID id;

    private String surname;

    private String name;

    private String patronymic;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Order> orders;

}
