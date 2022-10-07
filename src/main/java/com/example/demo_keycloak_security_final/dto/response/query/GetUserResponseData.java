package com.example.demo_keycloak_security_final.dto.response.query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.checker.units.qual.A;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetUserResponseData extends QueryResponseData{
    private String username;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
}
