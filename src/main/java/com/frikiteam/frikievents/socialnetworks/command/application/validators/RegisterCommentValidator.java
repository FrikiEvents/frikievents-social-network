package com.frikiteam.frikievents.socialnetworks.command.application.validators;

import com.frikiteam.frikievents.common.application.Notification;
import com.frikiteam.frikievents.socialnetworks.command.application.dtos.request.RegisterCommentRequest;
import org.springframework.stereotype.Component;

@Component
public class RegisterCommentValidator {
  public Notification validate(RegisterCommentRequest commentRegisterRequest)
  {
    Notification notification = new Notification();
    return notification;
  }
}
