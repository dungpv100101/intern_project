package com.example.demo_keycloak_security_final.service.command.button;

import com.example.demo_keycloak_security_final.entity.Button;

public interface ButtonCommandService {
    Button create(Button entity);
    Button update(Button entity);
    Long delete(Long id);
}
