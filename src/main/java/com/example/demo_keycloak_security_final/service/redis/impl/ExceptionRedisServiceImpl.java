package com.example.demo_keycloak_security_final.service.redis.impl;

import com.example.demo_keycloak_security_final.dto.redis.ExceptionCacheKey;
import com.example.demo_keycloak_security_final.entity.Exception;
import com.example.demo_keycloak_security_final.repository.redis.impl.ExceptionRedisRepository;
import com.example.demo_keycloak_security_final.service.redis.RedisService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExceptionRedisServiceImpl implements RedisService<ExceptionCacheKey, Exception> {
    private final ExceptionRedisRepository exceptionRedisRepository;

    @Override
    public Exception get(ExceptionCacheKey key) {
        return exceptionRedisRepository.get(getKey(key));
    }

    @Override
    public void delete(ExceptionCacheKey key) {
        exceptionRedisRepository.delete(getKey(key));
    }

    @Override
    public void put(Exception value) {
        exceptionRedisRepository.put(value);
    }

    private String getKey(ExceptionCacheKey key) {
        return key.getCode().toString();
    }
}
