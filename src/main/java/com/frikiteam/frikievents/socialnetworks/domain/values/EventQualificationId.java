package com.frikiteam.frikievents.socialnetworks.domain.values;

import lombok.Value;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Value(staticConstructor = "of")
public class EventQualificationId implements Serializable {
    private UUID id;

    public EventQualificationId(UUID id) {
        this.id = id;
    }

    protected EventQualificationId() {
        this.id = UUID.randomUUID();
    }
}
