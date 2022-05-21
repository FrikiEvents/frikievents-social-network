package com.frikiteam.socialnetworkboot.application.dtos;


import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Value
public class EventQualificationRegisterResponse {
    @TargetAggregateIdentifier
    private final String id;

    private final Integer starsQuantity;

}
