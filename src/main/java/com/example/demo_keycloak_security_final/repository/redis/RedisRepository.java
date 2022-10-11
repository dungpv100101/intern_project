package com.example.demo_keycloak_security_final.repository.redis;

public interface RedisRepository<K, V> {
    V get (K key);
    void delete(K key);
    void put(K key, V value);
}
