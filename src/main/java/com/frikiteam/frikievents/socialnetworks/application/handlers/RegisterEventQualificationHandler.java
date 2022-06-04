package com.frikiteam.frikievents.socialnetworks.application.handlers;


import com.frikiteam.frikievents.common.application.Notification;
import com.frikiteam.frikievents.common.application.Result;
import com.frikiteam.frikievents.socialnetworks.application.repositories.EventQualificationRepository;
import com.frikiteam.frikievents.socialnetworks.domain.entities.EventQualification;
import com.frikiteam.frikievents.socialnetworks.domain.values.EventQualificationId;
import com.frikiteam.frikievents.socialnetworks.application.commands.RegisterEventQualification;
import org.axonframework.commandhandling.CommandHandler;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RegisterEventQualificationHandler {

    private EventQualificationRepository eventQualificationRepository;
    public RegisterEventQualificationHandler(EventQualificationRepository eventQualificationRepository) {
        this.eventQualificationRepository = eventQualificationRepository;
    }

    @CommandHandler
    public Result<EventQualification, Notification> handle(RegisterEventQualification registerEventQualification) {
        Notification notification = new Notification();
        EventQualificationId eventQualificationId = EventQualificationId.of(UUID.fromString(registerEventQualification.getId()));
        if (notification.hasErrors()) {
            return Result.failure(notification);
        }
        EventQualification eventQualification = new EventQualification(eventQualificationId, registerEventQualification.getStarsQuantity());
        eventQualificationRepository.save(eventQualification);
        return Result.success(eventQualification);
    }
}
