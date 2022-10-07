package com.example.demo_keycloak_security_final.service.query.popup.impl;

import com.example.demo_keycloak_security_final.dto.redis.PopupCacheKey;
import com.example.demo_keycloak_security_final.entity.Popup;
import com.example.demo_keycloak_security_final.exception.ApplicationException;
import com.example.demo_keycloak_security_final.repository.query.popup.PopupQueryRepository;
import com.example.demo_keycloak_security_final.service.query.popup.PopupQueryService;
import com.example.demo_keycloak_security_final.service.redis.RedisService;
import com.example.demo_keycloak_security_final.util.ExceptionCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PopupQueryServiceImpl implements PopupQueryService {
    private final PopupQueryRepository popupQueryRepository;
    private final RedisService<PopupCacheKey, Popup> popupRedisService;

    @Override
    public Popup findByExceptionCodeAndLangCode(Long exceptionCode, String langCode) {
        Popup popup = popupRedisService.get(new PopupCacheKey(exceptionCode, langCode));

        if (popup != null) return popup;

        popup = popupQueryRepository.findPopupByExceptionCodeAndLangCodeFetchButton(exceptionCode, langCode);

        if (popup == null) {
            //Throw popup not found exception
            throw new ApplicationException(ExceptionCode.UNKNOWN_ERROR);
        }

        popupRedisService.put(popup);
        return popup;
    }

    @Override
    public Popup findById(Long id) {
        Popup popup = popupQueryRepository.findById(id).orElse(null);

        if (popup == null) {
            //Throw popup not found exception
            throw new ApplicationException(ExceptionCode.UNKNOWN_ERROR);
        }

        return popup;
    }

    @Override
    public Iterable<Popup> findAll() {
        return popupQueryRepository.findAll();
    }
}
