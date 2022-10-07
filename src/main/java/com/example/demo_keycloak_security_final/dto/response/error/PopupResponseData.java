package com.example.demo_keycloak_security_final.dto.response.error;

import com.example.demo_keycloak_security_final.dto.response.ResponseData;
import lombok.*;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PopupResponseData extends ResponseData {
    private String title;
    private String content;
    private String leftButton;
    private String rightButton;
}
