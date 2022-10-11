package com.example.demo_keycloak_security_final.handler.query.popup;

import com.example.demo_keycloak_security_final.dto.request.query.FindPopupRequestData;
import com.example.demo_keycloak_security_final.dto.response.query.FindPopupResponseData;
import com.example.demo_keycloak_security_final.entity.Popup;
import com.example.demo_keycloak_security_final.handler.query.QueryHandler;
import com.example.demo_keycloak_security_final.service.query.popup.impl.PopupQueryServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FindPopupHandler extends QueryHandler<FindPopupRequestData, FindPopupResponseData> {
    private final PopupQueryServiceImpl popupQueryService;
    @Override
    public FindPopupResponseData handle(FindPopupRequestData request) {
        return new FindPopupResponseData(getPopup(request));
    }

    private Popup getPopup(FindPopupRequestData request) {
        return popupQueryService.findByExceptionCodeAndLangCode(request.getExceptionCode(), request.getLangCode());
    }
}
