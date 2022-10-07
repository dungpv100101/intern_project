package com.example.demo_keycloak_security_final.repository.command.popup;

import com.example.demo_keycloak_security_final.entity.Popup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PopupCommandRepository extends JpaRepository<Popup, Long> {
    @Modifying
    @Query("delete from Popup p where p.exceptionCode = ?1 and p.langCode = ?2")
    int deletePopupByExceptionCodeAndLangCode(Long exceptionCode, String langCode);
}
