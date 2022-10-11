package com.example.demo_keycloak_security_final.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "language")
@Data
public class Language implements Serializable {

    @Id
    private String code;

    @Column(name = "title")
    private String title;
}
