package com.example.demo_keycloak_security_final.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "language")
@Getter
@Setter
public class Language implements Serializable {

    @Id
    private String code;

    @Column(name = "title")
    private String title;
}
