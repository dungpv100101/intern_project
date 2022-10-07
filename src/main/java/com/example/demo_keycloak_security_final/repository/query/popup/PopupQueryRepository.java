package com.example.demo_keycloak_security_final.repository.query.popup;

import com.example.demo_keycloak_security_final.entity.Popup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PopupQueryRepository extends JpaRepository<Popup, Long> {
    @Query("select p from Popup p join fetch p.button where p.exceptionCode = ?1 and p.langCode = ?2")
    Popup findPopupByExceptionCodeAndLangCodeFetchButton(Long exceptionCode, String langCode);
}
