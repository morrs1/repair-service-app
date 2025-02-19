package com.example.repairserviceapp.entities;

import io.hypersistence.utils.hibernate.type.range.PostgreSQLRangeType;
import io.hypersistence.utils.hibernate.type.range.Range;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "clients")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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

    @Type(PostgreSQLRangeType.class)
    @Column(
            name="sys_period",
            columnDefinition = "tstzrange"
    )
    private Range<ZonedDateTime> localDateRange;
}