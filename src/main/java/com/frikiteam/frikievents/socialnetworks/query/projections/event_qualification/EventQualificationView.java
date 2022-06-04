package com.frikiteam.frikievents.socialnetworks.query.projections.event_qualification;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Entity
@Getter
@Setter
public class EventQualificationView {
  @Id @Column
  private String eventQualificationId;

  @Column
  private Integer starsQuantity;

  private Instant createdAt;

  public EventQualificationView() {}

  public EventQualificationView(String eventQualificationId, Integer starsQuantity, Instant createdAt) {
    this.eventQualificationId = eventQualificationId;
    this.starsQuantity = starsQuantity;
    this.createdAt = createdAt;
  }
}