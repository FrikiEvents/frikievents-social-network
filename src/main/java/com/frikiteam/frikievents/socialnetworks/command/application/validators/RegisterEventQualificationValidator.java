package com.frikiteam.frikievents.socialnetworks.command.application.validators;

import com.frikiteam.frikievents.socialnetworks.command.application.dtos.request.RegisterEventQualificationRequest;
import org.springframework.stereotype.Component;
import com.frikiteam.frikievents.common.application.Notification;

@Component
public class RegisterEventQualificationValidator {
    public Notification validate(RegisterEventQualificationRequest eventQualificationRequest){
        Notification notification = new Notification();
        return notification;
    }
}
