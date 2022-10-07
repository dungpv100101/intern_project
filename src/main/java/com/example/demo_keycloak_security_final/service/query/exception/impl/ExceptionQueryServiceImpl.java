package com.example.demo_keycloak_security_final.service.query.exception.impl;

import com.example.demo_keycloak_security_final.dto.redis.ExceptionCacheKey;
import com.example.demo_keycloak_security_final.entity.Exception;
import com.example.demo_keycloak_security_final.exception.ApplicationException;
import com.example.demo_keycloak_security_final.repository.query.exception.ExceptionQueryRepository;
import com.example.demo_keycloak_security_final.service.query.exception.ExceptionQueryService;
import com.example.demo_keycloak_security_final.service.redis.RedisService;
import com.example.demo_keycloak_security_final.util.ExceptionCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExceptionQueryServiceImpl implements ExceptionQueryService {
    private final ExceptionQueryRepository exceptionQueryRepository;
    private final RedisService<ExceptionCacheKey, Exception> exceptionRedisService;
    @Override
    public Exception findById(Long id) {
        Exception exception = exceptionRedisService.get(new ExceptionCacheKey(id));
        if (exception != null) return exception;

        exception = exceptionQueryRepository.findById(id).orElse(null);

        if (exception == null) {
            //Throw exception not found exception
            throw new ApplicationException(ExceptionCode.UNKNOWN_ERROR);
        }

        exceptionRedisService.put(exception);
        return exception;
    }

    @Override
    public Iterable<Exception> findAll() {
        return exceptionQueryRepository.findAll();
    }

    @Override
    public boolean existsById(Long id) {
        return exceptionQueryRepository.existsById(id);
    }
}
