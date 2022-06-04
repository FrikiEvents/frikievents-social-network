package com.frikiteam.frikievents.socialnetworks.application.services;


import com.frikiteam.frikievents.common.application.Notification;
import com.frikiteam.frikievents.common.application.Result;
import com.frikiteam.frikievents.common.application.ResultType;
import com.frikiteam.frikievents.socialnetworks.application.commands.RegisterEventQualification;
import com.frikiteam.frikievents.socialnetworks.application.dtos.EventQualificationView;
import com.frikiteam.frikievents.socialnetworks.application.dtos.EventQualificationRegisterRequest;
import com.frikiteam.frikievents.socialnetworks.application.dtos.EventQualificationRegisterResponse;
import com.frikiteam.frikievents.socialnetworks.application.queries.GetEventQualificationByIdQuery;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Component
public class EventQualificationService {
    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    public EventQualificationService(CommandGateway commandGateway, QueryGateway queryGateway) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    public Result<EventQualificationRegisterResponse, Notification> registerEventQualification(EventQualificationRegisterRequest request) throws Exception {
        String eventQualificationId = UUID.randomUUID().toString();
        RegisterEventQualification registerEventQualification = new RegisterEventQualification(eventQualificationId, request.getStarsQuantity());
        CompletableFuture<Object> future = commandGateway.send(registerEventQualification);
        CompletableFuture<ResultType> result = future.handle((ok, ex) -> (ex != null) ? ResultType.FAILURE : ResultType.SUCCESS);
        ResultType resultType = result.get();
        if (resultType == ResultType.FAILURE) {
            throw new Exception("Error while register a Event Qualification");
        }

        EventQualificationRegisterResponse response = new EventQualificationRegisterResponse(
                registerEventQualification.getId(),
                registerEventQualification.getStarsQuantity()
        );
        return Result.success(response);
    }

    public EventQualificationView getById(String id)  throws Exception {
        CompletableFuture<EventQualificationView> future = queryGateway.query(new GetEventQualificationByIdQuery(id), ResponseTypes.instanceOf(EventQualificationView.class));
        CompletableFuture<ResultType> result = future.handle((ok, ex) -> (ex != null) ? ResultType.FAILURE : ResultType.SUCCESS);
        ResultType resultType = result.get();
        if (resultType == ResultType.FAILURE) {
            throw new Exception("Failure while getting a event qualification");
        }
        return future.get();

    }

}
