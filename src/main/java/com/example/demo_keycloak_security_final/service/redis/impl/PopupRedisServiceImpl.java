package com.example.demo_keycloak_security_final.service.redis.impl;

import com.example.demo_keycloak_security_final.dto.redis.PopupCacheKey;
import com.example.demo_keycloak_security_final.entity.Popup;
import com.example.demo_keycloak_security_final.repository.redis.impl.PopupRedisRepository;
import com.example.demo_keycloak_security_final.service.redis.RedisService;
import com.example.demo_keycloak_security_final.util.StringUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PopupRedisServiceImpl implements RedisService<PopupCacheKey, Popup> {
    private PopupRedisRepository popupRedisRepository;

    @Override
    public Popup get(PopupCacheKey key) {
        return popupRedisRepository.get(getKey(key));
    }

    @Override
    public void delete(PopupCacheKey key) {
        popupRedisRepository.delete(getKey(key));
    }

    @Override
    public void put(Popup value) {
        popupRedisRepository.put(getKey(value), value);
    }

    @Override
    public String getKey(PopupCacheKey key) {
        return key.getExceptionCode() + StringUtil.COMMA_CHARACTER + key.getLangCode();
    }
    public String getKey(Popup value) {
        return value.getExceptionCode() + StringUtil.COMMA_CHARACTER + value.getLangCode();
    }
}
