package com.example.demo_keycloak_security_final.config;

import com.example.demo_keycloak_security_final.constants.KeycloakConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class KeycloakAuthenticationConverter implements Converter<Jwt, Collection<GrantedAuthority>> {
    @Override
    public Collection<GrantedAuthority> convert(Jwt source) {
        Map<String, Object> realm_access = source.getClaimAsMap(KeycloakConstants.REALM_CLAIM_NAME);
        List<String> roles = (List<String>) realm_access.get(KeycloakConstants.ROLE_CLAIM_NAME);

        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(KeycloakConstants.ROLE_MARK + role))
                .collect(Collectors.toList());
    }
}
