package com.example.demo_keycloak_security_final.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "exception")
@Data
public class Exception implements Serializable {

    @Id
    private Long code;

    @Column(name = "description")
    private String description;
}
