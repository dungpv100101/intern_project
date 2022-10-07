package com.example.demo_keycloak_security_final.repository.command.button;

import com.example.demo_keycloak_security_final.entity.Button;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ButtonCommandRepository extends JpaRepository<Button, Long> {
    @Modifying
    @Query("delete from Button b where b.id = ?1")
    Long deleteButtonById(Long id);
}
