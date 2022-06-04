package com.frikiteam.frikievents.socialnetworks.command.application.services;

import com.frikiteam.frikievents.common.application.Notification;
import com.frikiteam.frikievents.common.application.Result;
import com.frikiteam.frikievents.common.application.ResultType;
import com.frikiteam.frikievents.socialnetworks.command.application.dtos.request.EditCommentRequest;
import com.frikiteam.frikievents.socialnetworks.command.application.dtos.request.RegisterCommentRequest;
import com.frikiteam.frikievents.socialnetworks.command.application.dtos.response.EditCommentResponse;
import com.frikiteam.frikievents.socialnetworks.command.application.dtos.response.RegisterCommentResponse;
import com.frikiteam.frikievents.socialnetworks.command.application.validators.RegisterCommentValidator;
import com.frikiteam.frikievents.socialnetworks.contracts.commands.EditComment;
import com.frikiteam.frikievents.socialnetworks.contracts.commands.RegisterComment;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Component
public class CommentApplicationService {
  private final CommandGateway commandGateway;

  private final RegisterCommentValidator registerCommentValidator;

  public CommentApplicationService(CommandGateway commandGateway, RegisterCommentValidator registerCommentValidator) {
    this.commandGateway = commandGateway;
    this.registerCommentValidator = registerCommentValidator;
  }

  public Result<RegisterCommentResponse, Notification> registerComment(RegisterCommentRequest commentRegisterRequest)
      throws Exception {
    Notification notification = this.registerCommentValidator.validate(commentRegisterRequest);
    if (notification.hasErrors()) {
      return Result.failure(notification);
    }
    String commentId = UUID.randomUUID().toString();
    RegisterComment registerComment = new RegisterComment(
        commentId,
        commentRegisterRequest.getContent()
    );
    CompletableFuture<Object> future = commandGateway.send(registerComment);
    CompletableFuture<ResultType> result = future.handle((ok, ex) -> (ex != null) ? ResultType.FAILURE : ResultType.SUCCESS);
    ResultType resultType = result.get();
    if (resultType == ResultType.FAILURE) {
      throw new Exception("Error while registering comment");
    }
    RegisterCommentResponse commentRegisterResponse = new RegisterCommentResponse(
        registerComment.getCommentId(),
        registerComment.getContent()
    );
    return Result.success(commentRegisterResponse);
  }

  public Result<EditCommentResponse, Notification> updateComment(String commentId, EditCommentRequest editCommentRequest) throws Exception {
    EditComment editComment = new EditComment(
        commentId,
        editCommentRequest.getContent()
    );
    CompletableFuture<Object> future = commandGateway.send(editComment);
    CompletableFuture<ResultType> result = future.handle((ok, ex) -> (ex != null) ? ResultType.FAILURE : ResultType.SUCCESS);
    ResultType resultType = result.get();
    if (resultType == ResultType.FAILURE) {
      throw new Exception("Error while updating comment");
    }
    EditCommentResponse editCommentResponse = new EditCommentResponse(
        editComment.getCommentId(),
        editComment.getContent()
    );
    return Result.success(editCommentResponse);
  }

}