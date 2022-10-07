package com.example.demo_keycloak_security_final.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ModelMapperUtil {
    private static final ModelMapper MODEL_MAPPER = new ModelMapper();
    public static <T> T map(Object sourceObject, Class<T> targetObjectClassType) {
        // update thư viện
        return MODEL_MAPPER.map(sourceObject, targetObjectClassType);
    }

}
