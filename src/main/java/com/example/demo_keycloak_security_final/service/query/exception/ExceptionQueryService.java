package com.example.demo_keycloak_security_final.service.query.exception;

import com.example.demo_keycloak_security_final.entity.Exception;

public interface ExceptionQueryService {
    Exception findById(Long id);
    Iterable<Exception> findAll();

    boolean existsById(Long id);
}
