package com.example.demo_keycloak_security_final.dto.response;

import com.example.demo_keycloak_security_final.dto.response.error.PopupResponseData;
import lombok.Data;

@Data
public class ErrorResponse extends ResponseData{
     private PopupResponseData popupResponseData;
}
