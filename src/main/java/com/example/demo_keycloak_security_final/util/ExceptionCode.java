package com.example.demo_keycloak_security_final.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionCode {
    public static final Long LOGIN_ERROR = 401L;
    public static final Long NOT_FOUND = 404L;
    public static final Long AVAILABLE = 409L;
    public static final Long UNKNOWN_ERROR = 500L;
}
