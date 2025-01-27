package com.example.repairserviceapp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "masters_list")
@Setter
@Getter
@ToString
public class Master {

    @Id
    @Column(name = "master_code")
    private UUID master_code;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "date_of_employment")
    private String dateOfEmployment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_code", referencedColumnName = "post_code")
    private Post post;

    @OneToMany(mappedBy="master")
    @ToString.Exclude
    private List<Order> orders;
}
