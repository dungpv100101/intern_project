package com.example.demo_keycloak_security_final.repository.redis;

import com.example.demo_keycloak_security_final.dto.redis.CacheKey;

public interface RedisRepository<K, V> {
    V get (K key);
    void delete(K key);
    void put(V value);
}
