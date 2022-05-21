package com.frikiteam.socialnetworkboot.application.handlers;


import com.frikiteam.socialnetworkboot.application.commands.RegisterEventQualification;
import com.frikiteam.socialnetworkboot.application.notification.Notification;
import com.frikiteam.socialnetworkboot.application.notification.Result;
import com.frikiteam.socialnetworkboot.application.repositories.EventQualificationRepository;
import com.frikiteam.socialnetworkboot.domain.entities.EventQualification;
import com.frikiteam.socialnetworkboot.domain.values.EventQualificationId;
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
