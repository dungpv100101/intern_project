package com.example.demo_keycloak_security_final.controller;

import com.example.demo_keycloak_security_final.dto.request.command.exception.CreateExceptionRequestData;
import com.example.demo_keycloak_security_final.dto.request.command.exception.DeleteExceptionRequestData;
import com.example.demo_keycloak_security_final.dto.request.command.exception.UpdateExceptionRequestData;
import com.example.demo_keycloak_security_final.dto.request.query.FindExceptionRequestData;
import com.example.demo_keycloak_security_final.dto.response.BaseResponse;
import com.example.demo_keycloak_security_final.dto.response.command.exception.CreateExceptionResponseData;
import com.example.demo_keycloak_security_final.dto.response.command.exception.DeleteExceptionResponseData;
import com.example.demo_keycloak_security_final.dto.response.command.exception.UpdateExceptionResponseData;
import com.example.demo_keycloak_security_final.dto.response.query.FindExceptionResponseData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exception")
public class ExceptionController extends BaseController{
    @GetMapping("/{code}")
    public ResponseEntity<BaseResponse<FindExceptionResponseData>> find(@PathVariable  Long code) {
        return getResponseEntity(new FindExceptionRequestData(code));
    }

    @PostMapping("/")
    public ResponseEntity<BaseResponse<CreateExceptionResponseData>> create(
            @RequestBody CreateExceptionRequestData request) {
        return getResponseEntity(request);
    }

    @PutMapping("/")
    public ResponseEntity<BaseResponse<UpdateExceptionResponseData>> update(
            @RequestBody UpdateExceptionRequestData request) {
        return getResponseEntity(request);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<BaseResponse<DeleteExceptionResponseData>> delete(
            @PathVariable Long code) {
        return getResponseEntity(new DeleteExceptionRequestData(code));
    }
}
