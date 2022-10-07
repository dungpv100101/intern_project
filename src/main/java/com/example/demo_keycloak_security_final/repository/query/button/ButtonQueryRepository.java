package com.example.demo_keycloak_security_final.repository.query.button;

import com.example.demo_keycloak_security_final.entity.Button;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ButtonQueryRepository extends JpaRepository<Button, Long> {
}
