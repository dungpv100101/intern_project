package com.example.demo_keycloak_security_final.service.command.button.impl;

import com.example.demo_keycloak_security_final.entity.Button;
import com.example.demo_keycloak_security_final.repository.command.button.ButtonCommandRepository;
import com.example.demo_keycloak_security_final.service.command.button.ButtonCommandService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ButtonCommandServiceImpl implements ButtonCommandService {
    private final ButtonCommandRepository buttonCommandRepository;

    @Override
    public Button update(Button entity) {
        return buttonCommandRepository.save(entity);
    }

    @Override
    public Button create(Button entity) {

        return buttonCommandRepository.save(entity);
    }

    @Override
    public Long delete(Long id) {

        return buttonCommandRepository.deleteButtonById(id);
    }
}
