package com.example.demo_keycloak_security_final.exception;

import com.example.demo_keycloak_security_final.dto.response.BaseResponse;
import com.example.demo_keycloak_security_final.dto.response.ResponseData;
import com.example.demo_keycloak_security_final.dto.response.error.PopupResponseData;
import com.example.demo_keycloak_security_final.entity.Popup;
import com.example.demo_keycloak_security_final.service.query.popup.PopupQueryService;
import lombok.AllArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class ExceptionHandle {
    private final PopupQueryService popupQueryService;

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<BaseResponse<?>> handle(ApplicationException e) {
        return new ResponseEntity<>(getBaseResponse(e), HttpStatus.valueOf(e.getResponseCode().intValue()));
    }
    public BaseResponse<ResponseData> getBaseResponse(ApplicationException e) {
        BaseResponse<ResponseData> baseResponse = new BaseResponse<>();

        baseResponse.setResponseCode(e.getResponseCode().intValue());

        PopupResponseData popupResponseData = getPopupResponseData(e);
        
        baseResponse.setResponseData(popupResponseData);
        baseResponse.setMessage(popupResponseData.getContent());
        return baseResponse;
    }

    private PopupResponseData getPopupResponseData(ApplicationException e) {
        String langCode = LocaleContextHolder.getLocale().getLanguage().toUpperCase();

        Popup popup = popupQueryService.findByExceptionCodeAndLangCode(e.getResponseCode(), langCode);

        return PopupResponseData.builder()
                    .title(popup.getTitle())
                    .content(popup.getContent())
                    .rightButton(popup.getButton().getRightBtn())
                    .leftButton(popup.getButton().getLeftBtn())
                .build();
    }
}
