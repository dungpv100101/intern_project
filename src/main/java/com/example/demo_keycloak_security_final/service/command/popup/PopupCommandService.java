package com.example.demo_keycloak_security_final.service.command.popup;

import com.example.demo_keycloak_security_final.entity.Popup;

public interface PopupCommandService{
    Popup create(Popup entity);

    Popup update(Popup entity);

    int deleteByExceptionCodeAndLangCode(Long exceptionCode, String langCode);
}
