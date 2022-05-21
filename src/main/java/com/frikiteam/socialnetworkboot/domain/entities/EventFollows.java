package com.frikiteam.socialnetworkboot.domain.entities;


import com.frikiteam.socialnetworkboot.domain.values.EventFollowsId;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "event_follows")
@Data
public class EventFollows {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "id", column = @Column(name = "id", columnDefinition = "BINARY(16)"))
    })
    private EventFollowsId id;

    public EventFollows(EventFollowsId eventFollowsId) {
        this.id = eventFollowsId;

    }

    public EventFollows() {}
}
