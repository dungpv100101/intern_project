package com.example.demo_keycloak_security_final.service.command.exception;

import com.example.demo_keycloak_security_final.entity.Exception;

public interface ExceptionCommandService {
    Exception create(Exception entity);
    Exception update(Exception entity);
    Long delete(Long id);
}
