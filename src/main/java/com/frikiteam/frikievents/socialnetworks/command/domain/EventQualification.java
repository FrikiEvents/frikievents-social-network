package com.frikiteam.frikievents.socialnetworks.command.domain;


import com.frikiteam.frikievents.socialnetworks.contracts.commands.EditEventQualification;
import com.frikiteam.frikievents.socialnetworks.contracts.commands.RegisterEventQualification;
import com.frikiteam.frikievents.socialnetworks.contracts.events.EventQualificationEdited;
import com.frikiteam.frikievents.socialnetworks.contracts.events.EventQualificationRegistered;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.time.Instant;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class EventQualification {
    @AggregateIdentifier
    private String eventQualificationId;

    private Integer starsQuantity;
    private Instant occurredOn;

    public EventQualification() {
    }

    @CommandHandler
    public EventQualification(RegisterEventQualification command) {

        apply(
            new EventQualificationRegistered(
                    command.getEventQualificationId(),
                    command.getStarsQuantity(),
                    command.getOccurredOn()

            )
        );
    }

    @CommandHandler
    public EventQualification(EditEventQualification command) {
        apply(
                new EventQualificationEdited(

                        command.getStarsQuantity()
                )
        );
    }

    @EventSourcingHandler
    protected void on(EventQualificationRegistered event) {
        this.eventQualificationId = event.getEventQualificationId();
        this.starsQuantity = event.getStarsQuantity();
    }


    protected void on(EventQualificationEdited event) {
        this.starsQuantity = event.getStarsQuantity();
    }

}
