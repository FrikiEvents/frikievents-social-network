package com.frikiteam.frikievents.socialnetworks.contracts.commands;

import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@Setter
public class EditEventQualification {

    private Integer starsQuantity;



    public EditEventQualification( int starsQuantity) {

        this.starsQuantity = starsQuantity;
    }
}
