package com.example.demo_keycloak_security_final.dto.request.query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetUserRequestData extends QueryRequestData{
    private String userID;
}
