package com.example.demo_keycloak_security_final.repository.query.exception;

import com.example.demo_keycloak_security_final.entity.Exception;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionQueryRepository extends JpaRepository<Exception, Long> {
}
