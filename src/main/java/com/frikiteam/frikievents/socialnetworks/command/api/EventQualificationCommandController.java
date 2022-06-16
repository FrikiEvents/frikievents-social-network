package com.frikiteam.frikievents.socialnetworks.command.api;

import com.frikiteam.frikievents.common.api.ApiController;
import com.frikiteam.frikievents.common.application.Notification;
import com.frikiteam.frikievents.common.application.Result;
import com.frikiteam.frikievents.socialnetworks.command.application.dtos.request.EditCommentRequest;
import com.frikiteam.frikievents.socialnetworks.command.application.dtos.request.EditEventQualificationRequest;
import com.frikiteam.frikievents.socialnetworks.command.application.dtos.request.RegisterEventQualificationRequest;
import com.frikiteam.frikievents.socialnetworks.command.application.dtos.response.EditCommentResponse;
import com.frikiteam.frikievents.socialnetworks.command.application.dtos.response.EditEventQualificationResponse;
import com.frikiteam.frikievents.socialnetworks.command.application.dtos.response.RegisterCommentResponse;
import com.frikiteam.frikievents.socialnetworks.command.application.dtos.response.RegisterEventQualificationResponse;
import com.frikiteam.frikievents.socialnetworks.command.application.services.EventQualificationApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.command.AggregateNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/event_qualifications")
@Tag(name = "EventsQualification")
public class EventQualificationCommandController {
    private final CommandGateway commandGateway;
    private final EventQualificationApplicationService eventQualificationApplicationService;

    public EventQualificationCommandController(CommandGateway commandGateway, EventQualificationApplicationService eventQualificationApplicationService) {
        this.commandGateway = commandGateway;
        this.eventQualificationApplicationService = eventQualificationApplicationService;
    }

    @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Register a new Event Qualification")
    public ResponseEntity<Object> register(@RequestBody RegisterEventQualificationRequest registerEventQualificationRequest) {
        try {
            Result<RegisterEventQualificationResponse, Notification> result = eventQualificationApplicationService.registerEventQualification(registerEventQualificationRequest);
            if (result.isSuccess()) {
                return ApiController.created(result.getSuccess());
            }
            return ApiController.error(result.getFailure().getErrors());
        } catch(Exception e) {
            return ApiController.serverError();
        }
    }

    @PutMapping(path = "/{eventQualificationId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update a new Event Qualification")
    public ResponseEntity<Object> update(@PathVariable("eventQualificationId") String eventQualificationId,@RequestBody EditEventQualificationRequest editEventQualificationRequest) {
        try {
            editEventQualificationRequest.setEventQualificationId(eventQualificationId);
            Result<EditEventQualificationResponse, Notification> result = eventQualificationApplicationService.updateEventQualification(editEventQualificationRequest);
            if (result.isSuccess()) {
                return ApiController.ok(result.getSuccess());
            }
            return ApiController.error(result.getFailure().getErrors());
        } catch (AggregateNotFoundException exception) {
            return ApiController.notFound();
        } catch(Exception e) {
            return ApiController.serverError();
        }
    }
}
