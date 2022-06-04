package com.frikiteam.frikievents.socialnetworks.query.projections.event_qualification;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;

@Entity
@Getter
@Setter
public class EventQualificationHistoryView {
    @Id @GeneratedValue
    private Long eventQualificationHistoryId;

    @Column
    private String eventQualificationId;

    @Column
    private Integer starsQuantity;

    private Instant createdAt;

    public EventQualificationHistoryView() {}

    public EventQualificationHistoryView(String eventQualificationId, Integer starsQuantity, Instant createdAt) {
        this.eventQualificationId = eventQualificationId;
        this.starsQuantity = starsQuantity;
        this.createdAt = createdAt;
    }

    public EventQualificationHistoryView(EventQualificationHistoryView eventQualificationHistoryView) {
        this.eventQualificationId = eventQualificationHistoryView.getEventQualificationId();
        this.starsQuantity = eventQualificationHistoryView.getStarsQuantity();
        this.createdAt = eventQualificationHistoryView.getCreatedAt();
    }
}
