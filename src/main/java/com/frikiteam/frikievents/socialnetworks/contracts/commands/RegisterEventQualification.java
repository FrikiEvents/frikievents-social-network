package com.frikiteam.frikievents.socialnetworks.contracts.commands;

import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@Setter
public class RegisterEventQualification {
    @TargetAggregateIdentifier
    private String eventQualificationId;
    private Integer starsQuantity;

    public RegisterEventQualification() {
    }

    public RegisterEventQualification(String eventQualificationId, int starsQuantity) {
        this.eventQualificationId = eventQualificationId;
        this.starsQuantity = starsQuantity;
    }
}
