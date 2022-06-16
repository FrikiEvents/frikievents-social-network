package com.frikiteam.frikievents.socialnetworks.command.application.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class RegisterEventQualificationRequest {
    private Integer starsQuantity;

    private Instant occurredOn;

    public RegisterEventQualificationRequest(Integer starsQuantity,Instant occurredOn) {

        this.starsQuantity = starsQuantity;
        this.occurredOn = occurredOn;
    }

    public RegisterEventQualificationRequest() {
    }
}
