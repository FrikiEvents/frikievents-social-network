package com.frikiteam.frikievents.socialnetworks.command.application.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterEventQualificationResponse {
    private String eventQualificationId;
    private Integer starsQuantity;

    public RegisterEventQualificationResponse() {
    }

    public RegisterEventQualificationResponse(String eventQualificationId, Integer starsQuantity) {
        this.eventQualificationId = eventQualificationId;
        this.starsQuantity = starsQuantity;
    }
}
