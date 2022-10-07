package com.example.demo_keycloak_security_final.repository.redis.impl;

import com.example.demo_keycloak_security_final.entity.Popup;
import com.example.demo_keycloak_security_final.repository.redis.RedisRepository;
import com.example.demo_keycloak_security_final.util.StringUtil;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class PopupRedisRepository implements RedisRepository<String, Popup> {
    private final RedisTemplate redisTemplate;
    private final String POPUP_KEY = "popups";

    @Override
    public Popup get(String key) {
        return (Popup) redisTemplate.opsForValue().get(POPUP_KEY + StringUtil.COLON_CHARACTER + key);
    }

    @Override
    public void delete(String key) {
        redisTemplate.delete(POPUP_KEY + StringUtil.COLON_CHARACTER + key);
    }

    @Override
    public void put(Popup value) {
        redisTemplate.opsForValue().set(
                POPUP_KEY
                        + StringUtil.COLON_CHARACTER
                        + value.getExceptionCode()
                        + StringUtil.COMMA_CHARACTER
                        + value.getLangCode()
                , value);
    }
}
