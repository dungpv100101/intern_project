package com.example.demo_keycloak_security_final.service.query.button;

import com.example.demo_keycloak_security_final.entity.Button;

public interface ButtonQueryService {
    Button findById(Long id);
    Iterable<Button> findAll();
    boolean existsById(Long id);
}
