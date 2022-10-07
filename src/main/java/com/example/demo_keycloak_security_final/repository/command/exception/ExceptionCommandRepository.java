package com.example.demo_keycloak_security_final.repository.command.exception;

import com.example.demo_keycloak_security_final.entity.Exception;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionCommandRepository extends JpaRepository<Exception, Long> {
    @Modifying
    @Query("delete from Exception e where e.code = ?1")
    Long deleteExceptionByCode(Long code);
}
