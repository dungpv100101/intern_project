package com.example.demo_keycloak_security_final.config;

import com.example.demo_keycloak_security_final.util.StringUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class AOPLoggerConfig {
    private final Logger logger = LoggerFactory.getLogger(AOPLoggerConfig.class);

    @Before("execution(* com.example.demo_keycloak_security_final..*.*(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String args = Arrays.toString(joinPoint.getArgs());

        String logString = "Executing: " + className + StringUtil.SPACE_CHARACTER + methodName + " with args: " + args;

        logger.info(logString);
    }

    @AfterReturning(value = "execution(* com.example.demo_keycloak_security_final..*.*(..))", returning = "result")
    public void logAfterMethod(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringTypeName();

        if (result != null) {
            String logString = "Return: " + className + StringUtil.SPACE_CHARACTER + methodName + StringUtil.SPACE_CHARACTER + result;
            logger.info(logString);
        }
    }

    @AfterThrowing(value = "execution(* com.example.demo_keycloak_security_final..*.*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringTypeName();

        String logString = "Error: " + className + StringUtil.SPACE_CHARACTER + methodName + StringUtil.SPACE_CHARACTER + exception.toString();

        logger.error(logString);
    }
}
