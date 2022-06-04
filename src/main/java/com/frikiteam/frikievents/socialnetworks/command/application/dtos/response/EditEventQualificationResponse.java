package com.frikiteam.frikievents.socialnetworks.command.application.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditEventQualificationResponse {
    private String eventQualificationId;
    private Integer starsQuantity;

    public EditEventQualificationResponse() {
    }

    public EditEventQualificationResponse(String eventQualificationId, Integer starsQuantity) {
        this.eventQualificationId = eventQualificationId;
        this.starsQuantity = starsQuantity;
    }
}
