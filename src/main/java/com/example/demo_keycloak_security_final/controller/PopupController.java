package com.example.demo_keycloak_security_final.controller;

import com.example.demo_keycloak_security_final.dto.request.command.popup.CreatePopupRequestData;
import com.example.demo_keycloak_security_final.dto.request.command.popup.DeletePopupRequestData;
import com.example.demo_keycloak_security_final.dto.request.command.popup.UpdatePopupRequestData;
import com.example.demo_keycloak_security_final.dto.request.query.FindPopupRequestData;
import com.example.demo_keycloak_security_final.dto.response.BaseResponse;
import com.example.demo_keycloak_security_final.dto.response.command.popup.CreatePopupResponseData;
import com.example.demo_keycloak_security_final.dto.response.command.popup.DeletePopupResponseData;
import com.example.demo_keycloak_security_final.dto.response.command.popup.UpdatePopupResponseData;
import com.example.demo_keycloak_security_final.dto.response.query.FindPopupResponseData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/popup")
public class PopupController extends BaseController{
    @GetMapping("")
    public ResponseEntity<BaseResponse<FindPopupResponseData>> find(
            @RequestParam(name = "lang") String langCode,
            @RequestParam(name = "id") Long exceptionCode) {
        return getResponseEntity(new FindPopupRequestData(langCode, exceptionCode));
    }

    @PostMapping("/")
    public ResponseEntity<BaseResponse<CreatePopupResponseData>> create(
            @RequestBody CreatePopupRequestData request) {
        return getResponseEntity(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse<UpdatePopupResponseData>> update(
            @RequestBody UpdatePopupRequestData request) {
        return getResponseEntity(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<DeletePopupResponseData>> delete(
            @PathVariable Long id) {
        return getResponseEntity(new DeletePopupRequestData(id));
    }

    @DeleteMapping("/{lang}/{id}")
    public ResponseEntity<BaseResponse<DeletePopupResponseData>> deleteByExceptionCodeAndLangCode(
            @RequestParam(name = "lang") String langCode,
            @RequestParam(name = "id") Long exceptionCode) {
        return getResponseEntity(new DeletePopupRequestData(exceptionCode, langCode));
    }
}
