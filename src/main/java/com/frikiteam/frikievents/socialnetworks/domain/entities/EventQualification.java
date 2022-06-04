package com.frikiteam.frikievents.socialnetworks.domain.entities;

import com.frikiteam.frikievents.socialnetworks.domain.values.EventQualificationId;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "event_qualifications")
@Data
public class EventQualification {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "id", column = @Column(name = "id", columnDefinition = "BINARY(16)"))
    })
    private EventQualificationId id;

    @Column(name = "stars_quantity")
    private Integer starsQuantity;

    public EventQualification(EventQualificationId eventQualificationId, Integer starsQuantity) {
        this.id = eventQualificationId;
        this.starsQuantity = starsQuantity;
    }

    public EventQualification() { }


    //TODO: Add the ticked and the event
}
