package com.example.repairserviceapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @Column(name = "post_code")
    private UUID id;

    @Column(name = "post_name")
    private String postName;

}
