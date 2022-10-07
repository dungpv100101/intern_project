package com.example.demo_keycloak_security_final.service.redis;

import com.example.demo_keycloak_security_final.dto.redis.CacheKey;

public interface RedisService<K extends CacheKey, V>{
    V get(K key);
    void delete(K key);
    void put(V value);
}
