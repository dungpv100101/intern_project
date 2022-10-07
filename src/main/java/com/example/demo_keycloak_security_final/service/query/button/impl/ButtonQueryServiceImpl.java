package com.example.demo_keycloak_security_final.service.query.button.impl;

import com.example.demo_keycloak_security_final.entity.Button;
import com.example.demo_keycloak_security_final.exception.ApplicationException;
import com.example.demo_keycloak_security_final.repository.query.button.ButtonQueryRepository;
import com.example.demo_keycloak_security_final.service.query.button.ButtonQueryService;
import com.example.demo_keycloak_security_final.util.ExceptionCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ButtonQueryServiceImpl implements ButtonQueryService {
    private final ButtonQueryRepository buttonQueryRepository;
    @Override
    public Button findById(Long id) {
        Button exception = buttonQueryRepository.findById(id).orElse(null);
        if (exception == null) {
            //Throw exception not found exception
            throw new ApplicationException(ExceptionCode.UNKNOWN_ERROR);
        }

        return exception;
    }

    @Override
    public Iterable<Button> findAll() {
        return buttonQueryRepository.findAll();
    }

    @Override
    public boolean existsById(Long id) {
        return buttonQueryRepository.existsById(id);
    }
}
