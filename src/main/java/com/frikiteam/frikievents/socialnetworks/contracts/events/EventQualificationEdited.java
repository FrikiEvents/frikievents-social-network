package com.frikiteam.frikievents.socialnetworks.contracts.events;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class EventQualificationEdited {
    private String eventQualificationId;
    private Integer starsQuantity;
    private Instant occurredOn;




    public EventQualificationEdited( Integer starsQuantity) {

        this.starsQuantity = starsQuantity;

    }
}
