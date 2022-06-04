package com.frikiteam.frikievents.socialnetworks.command.application.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterEventQualificationRequest {
    private Integer starsQuantity;

    public RegisterEventQualificationRequest(Integer starsQuantity) {
        this.starsQuantity = starsQuantity;
    }

    public RegisterEventQualificationRequest() {
    }
}
