package com.example.demo_keycloak_security_final.handler.command.popup;

import com.example.demo_keycloak_security_final.dto.request.command.popup.DeletePopupRequestData;
import com.example.demo_keycloak_security_final.dto.response.command.popup.DeletePopupResponseData;
import com.example.demo_keycloak_security_final.handler.command.CommandHandler;
import com.example.demo_keycloak_security_final.service.command.popup.PopupCommandService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeletePopupHandler extends CommandHandler<DeletePopupRequestData, DeletePopupResponseData> {
    private final PopupCommandService popupCommandService;
    @Override
    public DeletePopupResponseData handle(DeletePopupRequestData request) {
        int numberOfRowDeleted = popupCommandService.deleteByExceptionCodeAndLangCode(request.getExceptionCode(), request.getLangCode());

        return new DeletePopupResponseData(numberOfRowDeleted);
    }
}
