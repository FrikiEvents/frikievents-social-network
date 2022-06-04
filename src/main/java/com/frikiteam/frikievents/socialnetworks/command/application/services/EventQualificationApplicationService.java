package com.frikiteam.frikievents.socialnetworks.command.application.services;

import com.frikiteam.frikievents.common.application.Notification;
import com.frikiteam.frikievents.common.application.Result;
import com.frikiteam.frikievents.common.application.ResultType;
import com.frikiteam.frikievents.socialnetworks.command.application.dtos.request.EditCommentRequest;
import com.frikiteam.frikievents.socialnetworks.command.application.dtos.request.EditEventQualificationRequest;
import com.frikiteam.frikievents.socialnetworks.command.application.dtos.request.RegisterCommentRequest;
import com.frikiteam.frikievents.socialnetworks.command.application.dtos.request.RegisterEventQualificationRequest;
import com.frikiteam.frikievents.socialnetworks.command.application.dtos.response.EditCommentResponse;
import com.frikiteam.frikievents.socialnetworks.command.application.dtos.response.EditEventQualificationResponse;
import com.frikiteam.frikievents.socialnetworks.command.application.dtos.response.RegisterCommentResponse;
import com.frikiteam.frikievents.socialnetworks.command.application.dtos.response.RegisterEventQualificationResponse;
import com.frikiteam.frikievents.socialnetworks.command.application.validators.RegisterEventQualificationValidator;
import com.frikiteam.frikievents.socialnetworks.contracts.commands.EditComment;
import com.frikiteam.frikievents.socialnetworks.contracts.commands.EditEventQualification;
import com.frikiteam.frikievents.socialnetworks.contracts.commands.RegisterComment;
import com.frikiteam.frikievents.socialnetworks.contracts.commands.RegisterEventQualification;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
@Component
public class EventQualificationApplicationService {
    private final CommandGateway commandGateway;
    private final RegisterEventQualificationValidator registerEventQualificationValidator;


    public EventQualificationApplicationService(CommandGateway commandGateway, RegisterEventQualificationValidator registerEventQualificationValidator) {
        this.commandGateway = commandGateway;
        this.registerEventQualificationValidator = registerEventQualificationValidator;
    }

    public Result<RegisterEventQualificationResponse, Notification> registerEventQualification(RegisterEventQualificationRequest eventQualificationRegisterRequest)
            throws Exception {
        Notification notification = this.registerEventQualificationValidator.validate(eventQualificationRegisterRequest);
        if (notification.hasErrors()) {
            return Result.failure(notification);
        }
        String eventQualificationId = UUID.randomUUID().toString();
        RegisterEventQualification registerEventQualification = new RegisterEventQualification(
                eventQualificationId,
                eventQualificationRegisterRequest.getStarsQuantity()
        );
        CompletableFuture<Object> future = commandGateway.send(registerEventQualification);
        CompletableFuture<ResultType> result = future.handle((ok, ex) -> (ex != null) ? ResultType.FAILURE : ResultType.SUCCESS);
        ResultType resultType = result.get();
        if (resultType == ResultType.FAILURE) {
            throw new Exception("Error while registering Event Qualification");
        }
        RegisterEventQualificationResponse eventQualificationRegisterResponse = new RegisterEventQualificationResponse(
                registerEventQualification.getEventQualificationId(),
                registerEventQualification.getStarsQuantity()
        );
        return Result.success(eventQualificationRegisterResponse);
    }

    public Result<EditEventQualificationResponse, Notification> updateEventQualification(EditEventQualificationRequest editEventQualificationRequest) throws Exception {
        EditEventQualification editEventQualification = new EditEventQualification(
                editEventQualificationRequest.getEventQualificationId(),
                editEventQualificationRequest.getStarsQuantity()
        );
        CompletableFuture<Object> future = commandGateway.send(editEventQualification);
        CompletableFuture<ResultType> result = future.handle((ok, ex) -> (ex != null) ? ResultType.FAILURE : ResultType.SUCCESS);
        ResultType resultType = result.get();
        if (resultType == ResultType.FAILURE) {
            throw new Exception("Error while updating Event Qualification");
        }
        EditEventQualificationResponse editEventQualificationResponse = new EditEventQualificationResponse(
                editEventQualification.getEventQualificationId(),
                editEventQualification.getStarsQuantity()
        );
        return Result.success(editEventQualificationResponse);
    }
}
