package com.example.demo_keycloak_security_final.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "popup")
@Getter
@Setter
public class Popup implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="exception_code")
    private Long exceptionCode;

    @Column(name = "lang_code")
    private String langCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "btn_id")
    private Button button;

    private String title;
    private String content;
}
