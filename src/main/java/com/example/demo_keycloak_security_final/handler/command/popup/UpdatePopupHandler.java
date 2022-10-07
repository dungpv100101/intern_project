package com.example.demo_keycloak_security_final.handler.command.popup;

import com.example.demo_keycloak_security_final.dto.request.command.popup.UpdatePopupRequestData;
import com.example.demo_keycloak_security_final.dto.response.command.popup.UpdatePopupResponseData;
import com.example.demo_keycloak_security_final.entity.Button;
import com.example.demo_keycloak_security_final.entity.Popup;
import com.example.demo_keycloak_security_final.handler.command.CommandHandler;
import com.example.demo_keycloak_security_final.service.command.popup.PopupCommandService;
import com.example.demo_keycloak_security_final.service.query.button.ButtonQueryService;
import com.example.demo_keycloak_security_final.service.query.popup.PopupQueryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdatePopupHandler extends CommandHandler<UpdatePopupRequestData, UpdatePopupResponseData> {
    private final PopupCommandService popupCommandService;
    private final PopupQueryService popupQueryService;
    private final ButtonQueryService buttonQueryService;

    @Override
    public UpdatePopupResponseData handle(UpdatePopupRequestData request) {
        Popup popup = getPopup(request);

        Popup popupFromDB = popupQueryService.findById(request.getId());
        popupFromDB.setTitle(popup.getTitle());
        popupFromDB.setContent(popup.getContent());
        popupFromDB.setLangCode(popup.getLangCode());
        popupFromDB.setExceptionCode(popup.getExceptionCode());

        Button buttonFromDB = buttonQueryService.findById(request.getButtonId());
        popupFromDB.setButton(buttonFromDB);

        Popup result = popupCommandService.update(popupFromDB);

        return UpdatePopupResponseData.builder()
                .popup(result).build();
    }

    private Popup getPopup(UpdatePopupRequestData request) {
        Popup popup = new Popup();

        Button button = new Button();
        button.setId(request.getButtonId());

        popup.setId(request.getId());
        popup.setExceptionCode(request.getExceptionCode());
        popup.setLangCode(request.getLangCode());
        popup.setTitle(request.getTitle());
        popup.setContent(request.getContent());
        popup.setButton(button);
        return popup;
    }
}
