package com.example.demo_keycloak_security_final.service.command.popup.impl;

import com.example.demo_keycloak_security_final.dto.redis.PopupCacheKey;
import com.example.demo_keycloak_security_final.entity.Popup;
import com.example.demo_keycloak_security_final.exception.ApplicationException;
import com.example.demo_keycloak_security_final.repository.command.popup.PopupCommandRepository;
import com.example.demo_keycloak_security_final.service.command.popup.PopupCommandService;
import com.example.demo_keycloak_security_final.service.query.exception.ExceptionQueryService;
import com.example.demo_keycloak_security_final.service.redis.RedisService;
import com.example.demo_keycloak_security_final.util.ExceptionCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PopupCommandServiceImpl implements PopupCommandService {
    private final PopupCommandRepository popupCommandRepository;
    private final RedisService<PopupCacheKey, Popup> popupRedisService;

    @Override
    public Popup create(Popup entity) {
        return popupCommandRepository.save(entity);
    }

    @Override
    public Popup update(Popup entity) {
        popupRedisService.put(entity);
        return popupCommandRepository.save(entity);
    }

    @Override
    public int deleteByExceptionCodeAndLangCode(Long exceptionCode, String langCode) {
        int numberRowDeleted = popupCommandRepository.deletePopupByExceptionCodeAndLangCode(exceptionCode, langCode);

        if (numberRowDeleted < 0) {
            //Throw popup not found exception
            throw new ApplicationException(ExceptionCode.UNKNOWN_ERROR);
        }
        popupRedisService.delete(new PopupCacheKey(exceptionCode, langCode));
        return numberRowDeleted;
    }
}
