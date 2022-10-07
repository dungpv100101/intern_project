package com.example.demo_keycloak_security_final.controller;

import com.example.demo_keycloak_security_final.dto.request.command.RegisterRequestData;
import com.example.demo_keycloak_security_final.dto.request.query.GetUserRequestData;
import com.example.demo_keycloak_security_final.dto.request.query.LoginRequestData;
import com.example.demo_keycloak_security_final.dto.response.BaseResponse;
import com.example.demo_keycloak_security_final.dto.response.command.RegisterResponseData;
import com.example.demo_keycloak_security_final.dto.response.query.GetUserResponseData;
import com.example.demo_keycloak_security_final.dto.response.query.LoginResponseData;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class WebController extends BaseController{
    @GetMapping("/")
    public String index() {
        return "This is public page";
    }

    @PreAuthorize("hasRole('user')")
    @GetMapping("/private")
    public String secret() {
        return "This is private page";
    }

    //@PreAuthorize("hasAnyRole('user', 'admin')")
    @GetMapping("/users/{id}")
    public ResponseEntity<BaseResponse<GetUserResponseData>> getUser(
            @PathVariable String id) {
        return getResponseEntity(new GetUserRequestData(id));
    }

    @PostMapping("/login")
        public ResponseEntity<BaseResponse<LoginResponseData>> login(
            @RequestBody LoginRequestData requestData) {
        return getResponseEntity(requestData);
    }

    @PostMapping("/register")
    public ResponseEntity<BaseResponse<RegisterResponseData>> register(
            @RequestBody RegisterRequestData requestData) {
        return getResponseEntity(requestData);
    }
}
