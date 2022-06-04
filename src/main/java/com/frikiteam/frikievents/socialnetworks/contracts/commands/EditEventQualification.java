package com.frikiteam.frikievents.socialnetworks.contracts.commands;

import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@Setter
public class EditEventQualification {
    @TargetAggregateIdentifier
    private String eventQualificationId;
    private Integer starsQuantity;

    public EditEventQualification() { }

    public EditEventQualification(String eventQualificationId, int starsQuantity) {
        this.eventQualificationId = eventQualificationId;
        this.starsQuantity = starsQuantity;
    }
}
