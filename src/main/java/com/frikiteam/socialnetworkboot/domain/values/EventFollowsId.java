package com.frikiteam.socialnetworkboot.domain.values;


import lombok.Value;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Value(staticConstructor = "of")
public class EventFollowsId implements Serializable {
    private UUID id;

    public EventFollowsId(UUID id) {
        this.id = id;
    }

    public EventFollowsId() {
        this.id = UUID.randomUUID();
    }
}
