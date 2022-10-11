package com.example.demo_keycloak_security_final.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="button")
@Data
public class Button implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lang_code")
    private String langCode;

    @Column(name = "leftbtn")
    private String leftBtn;
    @Column(name = "rightbtn")
    private String rightBtn;
}
