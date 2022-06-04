package com.frikiteam.frikievents.socialnetworks.command.api;

import com.frikiteam.frikievents.common.api.ApiController;
import com.frikiteam.frikievents.common.application.Notification;
import com.frikiteam.frikievents.common.application.Result;
import com.frikiteam.frikievents.socialnetworks.command.application.dtos.request.EditCommentRequest;
import com.frikiteam.frikievents.socialnetworks.command.application.dtos.request.RegisterCommentRequest;
import com.frikiteam.frikievents.socialnetworks.command.application.dtos.response.EditCommentResponse;
import com.frikiteam.frikievents.socialnetworks.command.application.dtos.response.RegisterCommentResponse;
import com.frikiteam.frikievents.socialnetworks.command.application.services.CommentApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.command.AggregateNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
@Tag(name = "Comments")
public class CommentCommandController {
  private final CommentApplicationService commentApplicationService;
  private final CommandGateway commandGateway;

  public CommentCommandController(CommentApplicationService commentApplicationService, CommandGateway commandGateway) {
    this.commentApplicationService = commentApplicationService;
    this.commandGateway = commandGateway;
  }

  @PostMapping(path= "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Register a new comment")
  public ResponseEntity<Object> register(@RequestBody RegisterCommentRequest registerCommentRequest) {
    try {
      Result<RegisterCommentResponse, Notification> result = commentApplicationService.registerComment(registerCommentRequest);
      if (result.isSuccess()) {
        return ApiController.created(result.getSuccess());
      }
      return ApiController.error(result.getFailure().getErrors());
    } catch(Exception e) {
      return ApiController.serverError();
    }
  }

  @PutMapping("")
  @Operation(summary = "Edit a comment")
  public ResponseEntity<Object> update(@RequestBody EditCommentRequest editCommentRequest) {
    try {
      Result<EditCommentResponse, Notification> result = commentApplicationService.updateComment(editCommentRequest);
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
