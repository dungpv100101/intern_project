package com.example.demo_keycloak_security_final.service.command.exception.impl;

import com.example.demo_keycloak_security_final.dto.redis.ExceptionCacheKey;
import com.example.demo_keycloak_security_final.entity.Exception;
import com.example.demo_keycloak_security_final.repository.command.exception.ExceptionCommandRepository;
import com.example.demo_keycloak_security_final.service.command.exception.ExceptionCommandService;
import com.example.demo_keycloak_security_final.service.redis.RedisService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExceptionCommandServiceImpl implements ExceptionCommandService {
    private final ExceptionCommandRepository exceptionCommandRepository;
    private final RedisService<ExceptionCacheKey, Exception> exceptionRedisService;

    @Override
    public Exception update(Exception entity) {
        exceptionRedisService.put(entity);
        return exceptionCommandRepository.save(entity);
    }

    @Override
    public Exception create(Exception entity) {

        return exceptionCommandRepository.save(entity);
    }

    @Override
    public Long delete(Long code) {
        exceptionRedisService.delete(new ExceptionCacheKey(code));

        return exceptionCommandRepository.deleteExceptionByCode(code);
    }
}
