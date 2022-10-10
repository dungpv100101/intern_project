package com.example.demo_keycloak_security_final.config;

import com.example.demo_keycloak_security_final.util.StringUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class AOPLoggerConfig {
    @Around("execution(* com.example.demo_keycloak_security_final..*.*(..))")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        joinPoint.proceed();
    }
}
