package com.frikiteam.frikievents.socialnetworks.command.api;

import com.frikiteam.frikievents.common.api.ApiController;
import com.frikiteam.frikievents.common.application.Notification;
import com.frikiteam.frikievents.common.application.Result;
import com.frikiteam.frikievents.socialnetworks.command.application.dtos.request.CommentEditRequest;
import com.frikiteam.frikievents.socialnetworks.command.application.dtos.request.CommentRegisterRequest;
import com.frikiteam.frikievents.socialnetworks.command.application.dtos.response.CommentEditResponse;
import com.frikiteam.frikievents.socialnetworks.command.application.dtos.response.CommentRegisterResponse;
import com.frikiteam.frikievents.socialnetworks.command.application.services.CommentApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.axonframework.commandhandling.gateway.CommandGateway;
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

  @GetMapping("")
  public String getAll() {
    return "dsadasda";
  }

  @PostMapping(path = "")
  @Operation(summary = "Register a new comment")
  public ResponseEntity<Object> register(@RequestBody CommentRegisterRequest commentRegisterRequest) {
    try {
      Result<CommentRegisterResponse, Notification> result = commentApplicationService.registerComment(commentRegisterRequest);
      System.out.println("result: " + result);
      if (result.isSuccess()) {
        return ApiController.created(result.getSuccess());
      }
      return ApiController.error(result.getFailure().getErrors());
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
      return ApiController.serverError();
    }
  }

  @PutMapping(path = "/{id}" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> update(@PathVariable String id, @RequestBody CommentEditRequest commentEditRequest) {
    try {
      Result<CommentEditResponse, Notification> result = commentApplicationService.updateComment(id, commentEditRequest);
      if (result.isSuccess()) {
        return ApiController.ok(result.getSuccess());
      }
      return ApiController.error(result.getFailure().getErrors());
    } catch (Exception e) {
      return ApiController.serverError();
    }
  }

}
