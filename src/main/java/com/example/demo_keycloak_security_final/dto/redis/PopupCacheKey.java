package com.example.demo_keycloak_security_final.dto.redis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PopupCacheKey extends CacheKey{
    private Long exceptionCode;
    private String langCode;
}
