package com.frikiteam.frikievents.socialnetworks.query.projections.event_qualification;

import com.frikiteam.frikievents.socialnetworks.contracts.events.EventQualificationEdited;
import com.frikiteam.frikievents.socialnetworks.contracts.events.EventQualificationRegistered;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.Timestamp;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class EventQualificationViewProjection {
  private final EventQualificationViewRepository eventQualificationViewRepository;

  public EventQualificationViewProjection(EventQualificationViewRepository eventQualificationViewRepository) {
    this.eventQualificationViewRepository = eventQualificationViewRepository;
  }

  @EventHandler
  public void on(EventQualificationRegistered event, @Timestamp Instant timestamp) {
    EventQualificationView eventQualificationView = new EventQualificationView(event.getEventQualificationId(), event.getStarsQuantity(), event.getOccurredOn());
    eventQualificationViewRepository.save(eventQualificationView);
  }

  @EventHandler
  public void on(EventQualificationEdited event, @Timestamp Instant timestamp) {
    Optional<EventQualificationView> eventQualificationViewOptional = eventQualificationViewRepository.findById(event.getEventQualificationId().toString());
    if (eventQualificationViewOptional.isPresent()) {
      EventQualificationView eventQualificationView = eventQualificationViewOptional.get();
      eventQualificationView.setStarsQuantity(event.getStarsQuantity());
      eventQualificationView.setCreatedAt(event.getOccurredOn());
      eventQualificationViewRepository.save(eventQualificationView);
    }
  }
}