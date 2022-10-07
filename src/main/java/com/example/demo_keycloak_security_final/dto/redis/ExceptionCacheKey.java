package com.example.demo_keycloak_security_final.dto.redis;

import com.example.demo_keycloak_security_final.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionCacheKey extends CacheKey{
    private Long code;
}
