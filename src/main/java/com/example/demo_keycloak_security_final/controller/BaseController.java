package com.example.demo_keycloak_security_final.controller;

import com.example.demo_keycloak_security_final.dto.request.RequestData;
import com.example.demo_keycloak_security_final.dto.response.BaseResponse;
import com.example.demo_keycloak_security_final.dto.response.ResponseData;
import com.example.demo_keycloak_security_final.handler.HandlerManagement;
import com.example.demo_keycloak_security_final.handler.IHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {
    protected HandlerManagement handlerManagement;

    protected <T extends ResponseData> ResponseEntity<BaseResponse<T>> getResponseEntity(RequestData request) {
        IHandler handler = handlerManagement.getHandler(request);
        T response = (T) handler.handle(request);

        BaseResponse<T> baseResponse = new BaseResponse<>();

        baseResponse.setResponseCode(200);
        baseResponse.setResponseData(response);
        baseResponse.setMessage("success");
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @Autowired
    public void setHandlerManagement(HandlerManagement handlerManagement) {
        this.handlerManagement = handlerManagement;
    }
}
