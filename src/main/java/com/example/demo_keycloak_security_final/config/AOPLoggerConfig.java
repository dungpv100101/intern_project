package com.example.demo_keycloak_security_final.config;

import com.example.demo_keycloak_security_final.util.StringUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
public class AOPLoggerConfig {
    @Before("execution(* com.example.demo_keycloak_security_final..*.*(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String args = Arrays.toString(joinPoint.getArgs());

        System.out.println("Executing: " +
                className +
                StringUtil.SPACE_CHARACTER +
                methodName +
                " with args: " +
                args);
    }

    @AfterReturning(value = "execution(* com.example.demo_keycloak_security_final..*.*(..))", returning = "result")
    public void logAfterMethod(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringTypeName();

        if (result != null) System.out.println("Return: " +
                className +
                StringUtil.SPACE_CHARACTER +
                methodName +
                StringUtil.SPACE_CHARACTER +
                result);
    }
}
