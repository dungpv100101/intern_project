package com.example.demo_keycloak_security_final.handler.command.popup;

import com.example.demo_keycloak_security_final.dto.request.command.popup.CreatePopupRequestData;
import com.example.demo_keycloak_security_final.dto.response.command.popup.CreatePopupResponseData;
import com.example.demo_keycloak_security_final.entity.Button;
import com.example.demo_keycloak_security_final.entity.Popup;
import com.example.demo_keycloak_security_final.handler.command.CommandHandler;
import com.example.demo_keycloak_security_final.service.command.popup.PopupCommandService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreatePopupHandler extends CommandHandler<CreatePopupRequestData, CreatePopupResponseData> {
    private final PopupCommandService popupCommandService;

    @Override
    public CreatePopupResponseData handle(CreatePopupRequestData request) {
        return new CreatePopupResponseData(
                popupCommandService.create(getPopup(request)));
    }

    private Popup getPopup(CreatePopupRequestData request) {
        Popup popup = new Popup();

        Button button = new Button();
        button.setId(request.getButtonId());

        popup.setExceptionCode(request.getExceptionCode());
        popup.setLangCode(request.getLangCode());
        popup.setTitle(request.getTitle());
        popup.setContent(request.getContent());
        popup.setButton(button);

        return popup;
    }
}
