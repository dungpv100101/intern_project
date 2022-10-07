package com.example.demo_keycloak_security_final.config;

import com.example.demo_keycloak_security_final.constants.LocalConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Arrays;

@Configuration
public class LocalResolverConfig  {
    @Bean
    public LocaleResolver localResolver() {
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        localeResolver.setSupportedLocales(Arrays.asList(LocalConstants.VIETNAMESE, LocalConstants.ENGLISH));
        localeResolver.setDefaultLocale(LocalConstants.ENGLISH);

        return localeResolver;
    }
}
