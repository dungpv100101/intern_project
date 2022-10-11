package com.example.demo_keycloak_security_final.repository.redis.impl;

import com.example.demo_keycloak_security_final.entity.Exception;
import com.example.demo_keycloak_security_final.repository.redis.RedisRepository;
import com.example.demo_keycloak_security_final.util.StringUtil;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ExceptionRedisRepository implements RedisRepository<String, Exception> {

    private final RedisTemplate redisTemplate;
    private final String EXCEPTION_KEY = "exceptions";

    @Override
    public Exception get(String key) {
        return (Exception) redisTemplate.opsForValue().get(EXCEPTION_KEY + StringUtil.COLON_CHARACTER + key);
    }

    @Override
    public void delete(String key) {
        redisTemplate.delete(EXCEPTION_KEY + StringUtil.COLON_CHARACTER + key);
    }

    @Override
    public void put(String key, Exception value) {
        redisTemplate.opsForValue().set(EXCEPTION_KEY + StringUtil.COLON_CHARACTER + key, value);
    }
}
