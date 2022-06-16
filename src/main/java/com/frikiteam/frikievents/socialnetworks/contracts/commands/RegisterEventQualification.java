package com.frikiteam.frikievents.socialnetworks.contracts.commands;

import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.Instant;

@Getter
@Setter
public class RegisterEventQualification {
    @TargetAggregateIdentifier
    private String eventQualificationId;
    private Integer starsQuantity;
    private Instant occurredOn;
    public RegisterEventQualification() {
    }

    public RegisterEventQualification(String eventQualificationId, int starsQuantity, Instant occurredOn ) {
        this.eventQualificationId = eventQualificationId;
        this.starsQuantity = starsQuantity;
        this.occurredOn = occurredOn;
    }

    public String getEventQualificationId() {
        return eventQualificationId;
    }

    public void setEventQualificationId(String eventQualificationId) {
        this.eventQualificationId = eventQualificationId;
    }

    public Integer getStarsQuantity() {
        return starsQuantity;
    }

    public void setStarsQuantity(Integer starsQuantity) {
        this.starsQuantity = starsQuantity;
    }

    public Instant getOccurredOn() {
        return occurredOn;
    }

    public void setOccurredOn(Instant occurredOn) {
        this.occurredOn = occurredOn;
    }
}
