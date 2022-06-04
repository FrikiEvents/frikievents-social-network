package com.frikiteam.frikievents.socialnetworks.contracts.events;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class EventQualificationRegistered {
    private String eventQualificationId;
    private Integer starsQuantity;
    private Instant occurredOn;

    public EventQualificationRegistered() {
    }


    public EventQualificationRegistered(String eventQualificationId, Integer starsQuantity, Instant occurredOn) {
        this.eventQualificationId = eventQualificationId;
        this.starsQuantity = starsQuantity;
        this.occurredOn = occurredOn;
    }
}
