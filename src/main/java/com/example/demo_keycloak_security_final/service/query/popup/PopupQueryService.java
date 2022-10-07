package com.example.demo_keycloak_security_final.service.query.popup;

import com.example.demo_keycloak_security_final.entity.Popup;

public interface PopupQueryService {
    Popup findByExceptionCodeAndLangCode(Long exceptionCode, String langCode);
    Popup findById(Long id);
    Iterable<Popup> findAll();
}
