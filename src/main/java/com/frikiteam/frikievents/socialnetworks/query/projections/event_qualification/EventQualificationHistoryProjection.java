package com.frikiteam.frikievents.socialnetworks.query.projections.event_qualification;

import com.frikiteam.frikievents.socialnetworks.contracts.events.EventQualificationEdited;
import com.frikiteam.frikievents.socialnetworks.contracts.events.EventQualificationRegistered;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.Timestamp;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class EventQualificationHistoryProjection {
    private final EventQualificationHistoryViewRepository eventQualificationHistoryViewRepository;


    public EventQualificationHistoryProjection(EventQualificationHistoryViewRepository eventQualificationHistoryViewRepository) {
        this.eventQualificationHistoryViewRepository = eventQualificationHistoryViewRepository;
    }

    @EventHandler
    public void on(EventQualificationRegistered event, @Timestamp Instant timestamp) {
        EventQualificationHistoryView eventQualificationHistoryView = new EventQualificationHistoryView(event.getEventQualificationId(), event.getStarsQuantity(), event.getOccurredOn());
        eventQualificationHistoryViewRepository.save(eventQualificationHistoryView);
    }


    @EventHandler
    public void on(EventQualificationEdited event, @Timestamp Instant timestamp) {
        Optional<EventQualificationHistoryView> eventQualificationHistoryViewOptional = eventQualificationHistoryViewRepository.getLastByEventQualificationId(event.getEventQualificationId().toString());
        if (eventQualificationHistoryViewOptional.isPresent()) {
            EventQualificationHistoryView eventQualificationHistoryView = eventQualificationHistoryViewOptional.get();
            eventQualificationHistoryView = new EventQualificationHistoryView(eventQualificationHistoryView);
            eventQualificationHistoryView.setStarsQuantity(event.getStarsQuantity());
            eventQualificationHistoryView.setCreatedAt(event.getOccurredOn());
            eventQualificationHistoryViewRepository.save(eventQualificationHistoryView);
        }
    }
}
